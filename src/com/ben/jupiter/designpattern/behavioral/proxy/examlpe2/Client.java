/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Client.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月8日 上午11:25:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月8日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.proxy.examlpe2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ben
 *
 */
public class Client {

	private static Map<String, Constructor<?>> CONS_CACHE = new HashMap<String, Constructor<?>>();
	
	public static Object getProxy(Class clazz) throws InstantiationException, IllegalAccessException {
		System.out.println("get proxy");
		Object rtn = null;
		Class[] interceptors = new Class[]{};
		ProxyHandler handler = new ProxyHandler(clazz.newInstance(), interceptors);
		rtn = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
		return rtn;
	}
	
	public static Object getProxy1(Class clazz) throws Exception {
		System.out.println("get proxy1");
		Object rtn = null;
		Class[] interceptors = new Class[]{};
		Constructor cons = null;
		ProxyHandler handler = new ProxyHandler(clazz.newInstance(), interceptors);
		String key = (clazz.getInterfaces())[0].getName();
		
		cons = CONS_CACHE.get(key);
		if (cons == null) {
			synchronized (CONS_CACHE) {
				if (!CONS_CACHE.containsKey(key)) {
					Class proxyClazz = Proxy.getProxyClass(clazz.getClassLoader(), clazz.getInterfaces());
					cons = proxyClazz.getConstructor(InvocationHandler.class);
					CONS_CACHE.put(key, cons);
				}
			}
		}
		
		rtn = cons.newInstance(handler);
		return rtn;
	}
	
	public static void main(String[] args) throws Exception {
		ISubjectSV sv = (ISubjectSV)Client.getProxy1(SubjectSVImpl.class);
		sv.request();
	}
	
}
