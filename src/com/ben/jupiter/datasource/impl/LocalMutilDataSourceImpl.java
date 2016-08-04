/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: LocalMutilDataSourceImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月14日 下午5:45:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月14日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datasource.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ben.jupiter.datasource.interfaces.IDataSource;
import com.ben.jupiter.exception.JupiterException;

/**
 * @author Ben
 *
 */
public class LocalMutilDataSourceImpl extends AbstractLocalDataSourceImpl implements IDataSource {
	
	public LocalMutilDataSourceImpl() throws Exception {
		super();
	}

	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.datasource.interfaces.IDataSource#getConnectionFromDataSource(java.lang.String)
	 */
	@Override
	public Connection getConnectionFromDataSource(String ds) throws SQLException {
		Connection conn = null;
		try {
			DataSource datasource = DATASOURCE_MAP.get(ds);
			conn = datasource.getConnection();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new SQLException("get Connection error.", e);
		}
		return conn;
	}
	
	/**
	 * 获得标注 primary="true" 的数据库连接
	 * 
	 * @throws Exception
	 * @return String
	 */
	public String getPrimaryDataSource() throws Exception {
		if (PrimaryDataSource == null) {
			throw new JupiterException("primary dataSource is null.");
		}
		return PrimaryDataSource;
	}
}
