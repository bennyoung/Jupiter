/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ProxyHandler.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月7日 下午3:28:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月7日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.proxy.examlpe2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Ben
 *
 */
public class ProxyHandler implements InvocationHandler {
	
	private Object obj;
	
	private Class<?>[] intercepters;
	
	public ProxyHandler(Object obj, Class[] intercepters) {
		 this.obj = obj;
		 this.intercepters = intercepters;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("do before method.....");
		
		Object rtn = method.invoke(this.obj, args);
		
		System.out.println("do after method.....");
		
		return rtn;
	}

}
