/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: LocalMutilTransactionImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月13日 下午3:25:01 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.transaction.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;
import com.ben.jupiter.datasource.DataSourceFactory;
import com.ben.jupiter.datasource.LogicConnection;
import com.ben.jupiter.datasource.ReadOnlyConnection;
import com.ben.jupiter.datasource.WrapperConnection;
import com.ben.jupiter.datasource.interfaces.IDataSource;
import com.ben.jupiter.datasource.interfaces.IMutilTransactionDatasource;
import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.util.MiscHelper;
import com.ben.jupiter.util.UUID;

/**
 * @author Yang Bin
 *
 */
public class LocalMutilTransactionImpl extends AbstractTransactionImpl implements IMutilTransactionDatasource {

	private transient static Log log = LogFactory.getLog(LocalMutilTransactionImpl.class);
	
	private static ThreadLocal<Stack<ThreadInfo>> suspend = new ThreadLocal<>();

	private static ThreadLocal<ThreadInfo> tx = new ThreadLocal<>();

	public LocalMutilTransactionImpl() {
		super();
	}

	/**
	 * @param dataSourceName String
	 */
	public void setCurDataSource(String dataSourceName) {
		this.getThreadInfo().curDataSource = dataSourceName;
	}

	/**
	 * @return String
	 */
	public String getCurDataSource() {
		return this.getThreadInfo().curDataSource;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#isStartTransaction()
	 */
	@Override
	public boolean isStartTransaction() {
		ThreadInfo threadInfo = getThreadInfo();
		if (threadInfo == null) {
			return false;
		} else {
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#startTransaction()
	 */
	@Override
	public void startTransaction() throws Exception {
		if (isStartTransaction()) {
			throw new JupiterException("exist transaction: " + getThreadInfo().toString());
		}
		
		setThreadInfo(new ThreadInfo());
		
		// TODO: monitor transaction.
		
		// TODO: lisenter
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#commitTransaction()
	 */
	@Override
	public void commitTransaction() throws Exception {
		if (!isStartTransaction()) {
			throw new JupiterException("is not start transaction!");
		}
		
		Connection conn = null;
		String ds = null;
		List<Exception> exceptions = new ArrayList<Exception>();
		ThreadInfo info = this.getThreadInfo();
		HashMap<String, Connection> connections = info.txConnections;
		
		try {
			if (connections.size() != 0) {
				Set<String> set = connections.keySet();
				for (Iterator<String> it = set.iterator(); it.hasNext();) {
					ds = it.next();
					conn = connections.get(ds);
					try {
						conn.commit();
					} catch (Exception e) {
						exceptions.add(e);
						break;
					} finally {
						try {
							if (!conn.isClosed()) {
								conn.close();
							}
						} catch (Exception e) {
							throw new JupiterException("close connection failed!");
						}
					}
				}
				
				if (exceptions.size() != 0) {
					Collection<Connection> conns = connections.values();
					for (Iterator<Connection> it = conns.iterator(); it.hasNext();) {
						conn = it.next();
						try {
							conn.rollback();
						} catch (Exception e) {
							throw new JupiterException("connection roll back error.");
						} finally {
							try {
								if (!conn.isClosed()) {
									conn.close();
								}
							} catch (Exception e) {
								throw new JupiterException("close connection failed!");
							}
							
						}
					}
				}
			}
			
			//TOOD:TranscationMonitor
			
		} finally {
			this.afterCompletion();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#rollbackTransaction()
	 */
	@Override
	public void rollbackTransaction() throws Exception {
		if (!isStartTransaction()) {
			throw new JupiterException("is not start transaction!");
		}
		
		Connection conn = null;
		ThreadInfo info = this.getThreadInfo();
		HashMap<String, Connection> map = info.txConnections;
		
		try {
			if (map.size() != 0) {
				Collection<Connection> conns = map.values();
				for (Iterator<Connection> it = conns.iterator(); it.hasNext();) {
					conn = it.next();
					try {
						conn.rollback();
					} catch (Exception e) {
						throw new JupiterException("connection roll back error.");
					} finally {
						try {
							if (!conn.isClosed()) {
								conn.close();
							}
						} catch (Exception e) {
							throw new JupiterException("close connection failed!");
						}
					}
				}
			}
			
			//TODO: TransactionMonitor
			
		} finally {
			this.afterCompletion();
		}
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#suspend()
	 */
	@Override
	public void suspend() throws Exception {
		if (!isStartTransaction()) {
			throw new JupiterException("is not start transaction!");
		}
		
		ThreadInfo info = getThreadInfo();
		addSuspend(info);
		
		setThreadInfo(null);
		IDataSource.CUR_DATASOURCE.set(null);

		//TODO: TransactionMonitor
		log.info("transaction is suspend.");
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#resume()
	 */
	@Override
	public void resume() throws Exception {
		if (!isStartTransaction()) {
			throw new JupiterException("is not start transaction!");
		}
		
		ThreadInfo info = getSuspend().pop();
		setThreadInfo(info);
		log.info("transaction is resumed.");
	}

	/**
	 * 获得挂起信息
	 * @return Stack
	 */
	private Stack<ThreadInfo> getSuspend() {
		return suspend.get();
	}
	
	private void addSuspend(ThreadInfo info) {
		if (suspend.get() == null) {
			Stack<ThreadInfo> stack = new Stack<>();
			stack.add(info);
			suspend.set(stack);
		} else {
			Stack<ThreadInfo> stack = suspend.get();
			stack.add(info);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getTxId()
	 */
	@Override
	public String getTxId() {
		ThreadInfo info = this.getThreadInfo();
		return info.txid;
	}

	/**
	 * 设置线程信息
	 * @param threadInfo ThreadInfo
	 */
	private void setThreadInfo(ThreadInfo threadInfo) {
		tx.set(threadInfo);
	}

	/**
	 * 获得线程信息
	 * @return ThreadInfo
	 */
	private ThreadInfo getThreadInfo() {
		return (ThreadInfo) tx.get();
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getConnection()
	 */
	@Override
	public Connection getConnection() throws SQLException {
		String currentDataSource = null;
		if (IDataSource.CUR_DATASOURCE.get() == null) {
			currentDataSource = getThreadInfo().curDataSource;
		} else {
			currentDataSource = (String)IDataSource.CUR_DATASOURCE.get();
		}
		
		if (StringUtils.isBlank(currentDataSource)) {
			throw new SQLException("must set datasource.");
		}
		
		return getConnection(currentDataSource);
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getNewConnection()
	 */
	@Override
	public Connection getNewConnection() throws SQLException {
		String ds = IDataSource.CUR_DATASOURCE.get();
		if (StringUtils.isBlank(ds)) {
			ds = this.getThreadInfo().curDataSource;
		}
		if (StringUtils.isBlank(ds)) {
			throw new SQLException("must set datasource.");
		}
		return this._getConnection(true, ds);
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getNewConnection(java.lang.String)
	 */
	@Override
	public Connection getNewConnection(String sourceName) throws SQLException {
		return this._getConnection(true, sourceName);
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getConnection(java.lang.String)
	 */
	@Override
	public Connection getConnection(String sourceName) throws SQLException {
		return this._getConnection(false, sourceName);
	}
	
	/**
	 * 
	 * @Function: LocalMutilTransactionImpl.java
	 * @Description: 获取数据库逻辑连接
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Ben
	 * @date: 2016年7月14日 下午7:27:35
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2016年7月14日     Ben           v1.0.0               修改原因
	 */
	public Connection _getConnection(boolean isNew, String ds) throws SQLException {
		Connection conn = null;
		
		if (isNew) {
			conn = new WrapperConnection(ds, DataSourceFactory.getDataSource().getConnectionFromDataSource(ds));
		} else {
			if (isStartTransaction()) {
				ThreadInfo info = this.getThreadInfo();
				if (info.txConnections.containsKey(ds)) {
					conn = new LogicConnection(info.txConnections.get(ds));
				} else {
					Connection connection = DataSourceFactory.getDataSource().getConnectionFromDataSource(ds);
					if (connection.isReadOnly()) {
						connection.rollback();
					}
					info.txConnections.put(ds, connection);
					conn = new LogicConnection(connection);
				}
			} else {
				conn = new ReadOnlyConnection(DataSourceFactory.getDataSource().getConnectionFromDataSource(ds));
			}
		}
		
		return conn;
	}
	
	/**
	 * 执行完毕后
	 */
	private void afterCompletion() throws Exception {
//		if (this.getSuspend() == null || this.getSuspend().size() != 0) {
			setThreadInfo(null);
			IDataSource.CUR_DATASOURCE.set(null);
//		} else {
//			
//		}
	}
	
	/**
	 * 线程信息对象
	 * @author Ben
	 */
	private static class ThreadInfo {
		
		private transient static Log log = LogFactory.getLog(ThreadInfo.class);
		
		private static Boolean SHOW_DETAIL = null;
	    String txid = "";
	    HashMap<String, Connection> txConnections = new HashMap<String, Connection>();
	    Date start = null;
	    String curDataSource = null;
	    String callPath = null;
	    String threadName = null;
	    
	    ThreadInfo() {
	    	start = new Date();
	    	txid = UUID.getID();
	    	callPath = MiscHelper.getCallPath();
			threadName = Thread.currentThread().getName();
			
	    	if (SHOW_DETAIL == null) {
	    		try {
	    			Property[] prop = XMLHelper.getInstance().getDefaults().getTransaction().getClazz().getProperties();
	    			for (int i = 0; i < prop.length; i++) {
	    				if (prop[i].getName().equalsIgnoreCase("showDetail") && prop[i].getValue().equalsIgnoreCase("true")) {
	    					SHOW_DETAIL = Boolean.TRUE;
	    				}
	    			}
	    		} catch (Exception e) {
	    			throw new RuntimeException("read showDetail content error", e);
	    		}
	    	}
	    }
	    
	    public String toString() {
	    	String rtn = null;
	    	if (SHOW_DETAIL != null && SHOW_DETAIL.equals(Boolean.TRUE)) {
	    		rtn = "transaction ID:" + txid + ", start:" + start + ", threadName:" + threadName + ", callPath:" + callPath;
	    	} else {
	    		rtn = "transaction ID:" + txid;
	    	}
	    	return rtn;
	    }
	}
	
}
