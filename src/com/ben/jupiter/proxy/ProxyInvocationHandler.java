/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ProxyInvocationHandler.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 15:34:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor;
import com.ben.jupiter.proxy.interfaces.BeforeMethodInterceptor;
import com.ben.jupiter.proxy.interfaces.InvokerListener;

/**
 * @author Yang Bin
 * 代理拦截实现
 */
public class ProxyInvocationHandler implements InvocationHandler {

	private transient static Log log = LogFactory.getLog(ProxyInvocationHandler.class);
	
	private Object _obj;
	private Class[] _interceptors_class;
	
	public ProxyInvocationHandler(Object _obj, Class[] interceptors_class) {
		this._obj = _obj;
		this._interceptors_class = interceptors_class;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		// 拦截器实例化
		Object[] _interceptors = new Object[_interceptors_class.length];
		for (int i = 0; i < _interceptors_class.length; i++) {
			_interceptors[i] = _interceptors_class[i].newInstance();
		}
		
		List<InvokerListener> listeners = new ArrayList<InvokerListener>(_interceptors_class.length);
		boolean[] isBeforeSuccess = new boolean[_interceptors.length];
		
		try {
			for (int i = 0; i < _interceptors.length; i++) {
				// 方法前拦截器
				if (_interceptors[i] instanceof BeforeMethodInterceptor) {
					((BeforeMethodInterceptor)_interceptors[i]).interceptor(this._obj, method.getName(), args);
					isBeforeSuccess[i] = true;
				} else if (_interceptors[i] instanceof AroundMethodInterceptor) {
					((AroundMethodInterceptor)_interceptors[i]).beforeInterceptor(this._obj, method.getName(), args);
					isBeforeSuccess[i] = true;
				} else {
					throw new JupiterException("there is wrong intercepter implements:[" + _interceptors[i].getClass().getName() + "]");
				}
				
				// 监听器
				if (_interceptors[i] instanceof InvokerListener) {
					listeners.add((InvokerListener)_interceptors[i]);
				}
			}
			
		} catch (Exception e) {
			log.fatal("在方法调用前的拦截器失败!");
			
			//将已经工作过的拦截器进行反向处理
			for (int i = _interceptors.length - 1; i >= 0; i--) {
				if (isBeforeSuccess[i] == true) {
					//仅仅只有环绕拦截器需要反向处理
					if (_interceptors[i] instanceof AroundMethodInterceptor) {
						((AroundMethodInterceptor)_interceptors[i]).exceptionInterceptor(this._obj, method.getName(), args);
					}
				}
			}
			
			throw e;
		}
		
		Object rtn = null;
		try {
			// 监听器
			if (!listeners.isEmpty()) {
				for (InvokerListener listener : listeners) {
					listener.beforeInvoker(this._obj, method.getName(), args);
				}
			}
			
			// 调用真实方法
			rtn = method.invoke(this._obj, args);
			
			if (!listeners.isEmpty()) {
				for (InvokerListener listener : listeners) {
					listener.afterInvoker(this._obj, method.getName(), args);
				}
			}
			
			
		} catch (Exception e) {
			
		}
		
		return rtn;
	}

}
