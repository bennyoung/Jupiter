/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Session.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月13日 上午11:31:09 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.transaction.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import com.ben.jupiter.monitor.MonitorItem;

/**
 * @author Yang Bin
 *
 */
public interface Session {
	
	/**
	 * 判断是否已经开始事务
	 * 
	 * @return boolean
	 */
	public boolean isStartTransaction();

	/**
	 * 开始事务
	 * 
	 * @throws Exception
	 */
	public void startTransaction() throws Exception;

	/**
	 * 开始事务,指定特殊的数据源
	 * 
	 * @param dataSourceName
	 *            String
	 * @throws Exception
	 */
	public void startTransaction(String transactionName) throws Exception;

	/**
	 * 提交事务
	 * 
	 * @throws AIException
	 */
	public void commitTransaction() throws Exception;

	/**
	 * 回滚事务
	 * 
	 * @throws AIException
	 */
	public void rollbackTransaction() throws Exception;

	/**
	 * 获取一个缺省数据源连接.如果已经开始事务,此间接自动参与事务
	 * 
	 * @throws SQLException
	 * @return Connection 数据库连接
	 */
	public Connection getConnection() throws SQLException;

	/**
	 * 获取一个不参与事务的连接
	 * 
	 * @throws SQLException
	 * @return Connection 数据库连接
	 */
	public Connection getNewConnection() throws SQLException;

	/**
	 * 获取指定数据源的一个不参与事务的连接
	 * 
	 * @param sourceName
	 *            String 数据源名称
	 * @throws SQLException
	 * @return Connection 数据库连接
	 */
	public Connection getNewConnection(String sourceName) throws java.sql.SQLException;

	/**
	 * 获取指定数据源的一个连接.如果已经开始事务,此间接自动参与事务
	 * 
	 * @param sourceName
	 *            String 数据源名称
	 * @throws SQLException
	 * @return Connection
	 */
	public Connection getConnection(String sourceName) throws java.sql.SQLException;

	/**
	 * 挂起事务
	 * 
	 * @throws Exception
	 */
	public void suspend() throws Exception;

	/**
	 * 恢复事务
	 * 
	 * @throws Exception
	 */
	public void resume() throws Exception;

	public String debuger();

	public MonitorItem[] getOpenTransaction();

	/**
	 * 强制回滚事务
	 * 
	 * @param classHashCode
	 *            String
	 * @throws Exception
	 */
	public void forceRollbackTransaction(String classHashCode) throws Exception;

	/**
	 * 修改当前事务的缺省数据源
	 * 
	 * @param newDataSource
	 *            String
	 */
	public void suspendDataSource(String newDataSource) throws Exception;

	/**
	 * 恢复原来的确认数据源
	 */
	public void resumeDataSource() throws Exception;

	public String getCurrentTransactionName();

	public String getDefualtDataSourceOfCurrentTransaction();

	public String getDefualtDataSourceByTransactionName(String transactionName) throws Exception;

	public String getTxId();
}
