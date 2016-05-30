/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AroundMethod2Interceptor.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 19 May 2016 19:09:35 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 19 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy.interfaces;

/**
 * @author Yang Bin
 *
 */
public interface AroundMethod2Interceptor {

	/**
	 * 拦截
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void beforeInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception;

	/**
	 * 拦截
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void afterInterceptor(Object obj, String methodName, Object[] objectArray, Object object) throws Exception;

	/**
	 * 异常拦截
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void exceptionInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception;

	
}
