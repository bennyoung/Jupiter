/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: TransactionDataSourceInterceptorImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Mar 2016 21:27:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy.impl;

import com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor;

/**
 * @author Yang Bin
 *
 */
public class TransactionDataSourceInterceptorImpl implements AroundMethodInterceptor {

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#beforeInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void beforeInterceptor(Object obj, String methodName,
			Object[] objectArray) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#afterInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void afterInterceptor(Object obj, String methodName,
			Object[] objectArray) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#exceptionInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void exceptionInterceptor(Object obj, String methodName,
			Object[] objectArray) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
