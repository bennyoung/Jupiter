/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AbstractTransactionImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月13日 下午3:22:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.transaction.impl;

import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.monitor.MonitorItem;
import com.ben.jupiter.transaction.interfaces.Session;

/**
 * @author Ben
 *
 */
public abstract class AbstractTransactionImpl implements Session {

	public AbstractTransactionImpl() {
		
	}
	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.transaction.interfaces.Session#startTransaction(java.lang.String)
	 */
	@Override
	public void startTransaction(String transactionName) throws Exception {
		if (true) {
			throw new JupiterException("do not support start transaction with transaction name....");
		}
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
	 * @see com.ben.jupiter.transaction.interfaces.Session#getOpenTransaction()
	 */
	@Override
	public MonitorItem[] getOpenTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return String
	 */
	public String getDefualtDataSourceOfCurrentTransaction() {
		return null;
	}

	/**
	 * 
	 * @param transactionName String
	 * @return String
	 */
	public String getDefualtDataSourceByTransactionName(String transactionName) {
		return null;
	}

	/**
	 * 获得当前数据源名称
	 * @return String
	 */
	public String getCurrentTransactionName() {
		return null;
	}

	/**
	 * 调试
	 * @return String
	 */
	public String debuger() {
		return null;
	}
}
