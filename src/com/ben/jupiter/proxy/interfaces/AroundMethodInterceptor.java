/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AroundMethodInterceptor.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 15:36:02 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy.interfaces;

/**
 * @author Yang Bin
 *
 */
public interface AroundMethodInterceptor {

	/**
	 * 拦截
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void beforeInterceptor(Object obj,String methodName,Object[] objectArray) throws Exception;

	/**
	 * 拦截
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void afterInterceptor(Object obj,String methodName,Object[] objectArray) throws Exception;

	/**
	 * 异常拦截
	 * @param obj Object
	 * @param methodName String
	 * @param objectArray Object[]
	 * @throws Exception
	 */
	public void exceptionInterceptor(Object obj,String methodName,Object[] objectArray) throws Exception;
	  
}
