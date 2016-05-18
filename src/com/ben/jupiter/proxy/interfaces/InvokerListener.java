/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: InvokerListener.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 16 May 2016 21:50:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 16 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy.interfaces;

/**
 * @author Yang Bin
 *
 */
public interface InvokerListener {

	/**
	 * beforeInvoker
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void beforeInvoker(Object obj, String methodName, Object[] objectArray) throws Exception;

	/**
	 * afterInvoker
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void afterInvoker(Object obj, String methodName, Object[] objectArray) throws Exception;
	  
}
