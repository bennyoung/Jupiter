/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AfterMethodInterceptor.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 15:36:30 
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
public interface AfterMethodInterceptor {

	/**
     * 拦截
     * @param obj Object
     * @param methodName String
     * @param objectArray Object[]
     * @throws Exception
     */
	public void interceptor(Object obj,String methodName,Object[] objectArray) throws Exception;
	
}
