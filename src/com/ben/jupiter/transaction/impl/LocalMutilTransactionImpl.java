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
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;
import com.ben.jupiter.datasource.interfaces.IDataSource;
import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.monitor.MonitorItem;
import com.ben.jupiter.util.MiscHelper;
import com.ben.jupiter.util.UUID;

/**
 * @author Yang Bin
 *
 */
public class LocalMutilTransactionImpl extends AbstractTransactionImpl {

	private transient static Log log = LogFactory.getLog(LocalMutilTransactionImpl.class);
	
	private static ThreadLocal suspend = new ThreadLocal();

	private static ThreadLocal tx = new ThreadLocal();

	public LocalMutilTransactionImpl() {
		super();
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
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#rollbackTransaction()
	 */
	@Override
	public void rollbackTransaction() throws Exception {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getNewConnection(java.lang.String)
	 */
	@Override
	public Connection getNewConnection(String sourceName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getConnection(java.lang.String)
	 */
	@Override
	public Connection getConnection(String sourceName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#suspend()
	 */
	@Override
	public void suspend() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#resume()
	 */
	@Override
	public void resume() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#debuger()
	 */
	@Override
	public String debuger() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getOpenTransaction()
	 */
	@Override
	public MonitorItem[] getOpenTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#forceRollbackTransaction(java.lang.String)
	 */
	@Override
	public void forceRollbackTransaction(String classHashCode) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#suspendDataSource(java.lang.String)
	 */
	@Override
	public void suspendDataSource(String newDataSource) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#resumeDataSource()
	 */
	@Override
	public void resumeDataSource() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getCurrentTransactionName()
	 */
	@Override
	public String getCurrentTransactionName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getDefualtDataSourceOfCurrentTransaction()
	 */
	@Override
	public String getDefualtDataSourceOfCurrentTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getDefualtDataSourceByTransactionName(java.lang.String)
	 */
	@Override
	public String getDefualtDataSourceByTransactionName(String transactionName)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#getTxId()
	 */
	@Override
	public String getTxId() {
		// TODO Auto-generated method stub
		return null;
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
	  
	/**
	 * 线程信息对象
	 * @author Ben
	 */
	private static class ThreadInfo {
		
		private transient static Log log = LogFactory.getLog(ThreadInfo.class);
		
		private static Boolean SHOW_DETAIL = null;
	    String txid = "";
	    HashMap txConnections = new HashMap();
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
