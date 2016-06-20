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
}
