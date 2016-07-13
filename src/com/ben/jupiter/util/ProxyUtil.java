/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ProxyUtil.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Mar 2016 21:58:06 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang Bin
 *
 */
public class ProxyUtil {

	//优化newProxyInstance
	private static final Class CONSTRUCT_PARAM = InvocationHandler.class;
	private static final Map CONS_CACHE = new HashMap();
	
	private ProxyUtil() {
		
	}
	
	public static final Object getProxyObject(ClassLoader loader, Class[] interfaces, InvocationHandler h) {
		Object rtn = null;
		Class c = null;
		String key = interfaces[0].getName();
		Constructor cons = (Constructor) CONS_CACHE.get(key);
		if (cons == null) {
			synchronized (CONS_CACHE) {
				if (!CONS_CACHE.containsKey(key)) {
					c = Proxy.getProxyClass(loader, interfaces);
					try {
						cons = c.getConstructor(CONSTRUCT_PARAM);
					} catch (NoSuchMethodException e) {
						throw new InternalError(e.toString());
					}
					CONS_CACHE.put(key, cons);
				}
				cons = (Constructor)CONS_CACHE.get(key);
			}
		}
		try {
			rtn = (Object)cons.newInstance(new Object[]{h});
		} catch (IllegalAccessException e) {
			throw new InternalError(e.toString());
	    } catch (InstantiationException e) {
	    	throw new InternalError(e.toString());
	    } catch (InvocationTargetException e) {
	    	throw new InternalError(e.toString());
	    }
		
		return rtn;
	}
	
}
