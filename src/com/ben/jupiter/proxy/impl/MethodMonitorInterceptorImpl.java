/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: MethodMonitorInterceptorImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Mar 2016 21:26:45 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Clazz;
import com.ben.jupiter.complex.xml.cfg.defaults.Interceptor;
import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.proxy.interfaces.AroundMethod2Interceptor;
import com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor;

/**
 * @author Yang Bin
 *
 */
public class MethodMonitorInterceptorImpl implements AroundMethodInterceptor {

	private transient static Log log = LogFactory.getLog(MethodMonitorInterceptorImpl.class);
	
	//是否入口方法
	private static final ThreadLocal IS_FIRST_METHOD = new ThreadLocal();

	//自定义的环绕拦截
	private static Class[] CUSTOM_INTERCEPTOR_CLASS = null;
	
	private AroundMethod2Interceptor[] method2InterceptorObjects = null;

	//入口方法
	private boolean isFirstMethod = false;

	//返回值
	private Object methodReturnObj;

	static {
		try {
			Interceptor interceptor = XMLHelper.getInstance().getDefaults().getInterceptor();
			if (interceptor != null) {
				Clazz[] clazz = interceptor.getClazzs();
				if (clazz != null) {
					CUSTOM_INTERCEPTOR_CLASS = new Class[clazz.length];
					for (int i = 0; i > clazz.length; i++) {
						try {
							if (StringUtils.isNotBlank(clazz[i].getName().trim())) {
								CUSTOM_INTERCEPTOR_CLASS[i] = Class.forName(clazz[i].getName());
							}
						} catch (ClassNotFoundException e) {
							throw new RuntimeException("Interceptor " + clazz[i].getName() + " class not found");
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("init MethodMonitorInterceptorImpl failed!", e);
			throw new RuntimeException(e);
		}
	}
	
	public MethodMonitorInterceptorImpl() {
		AroundMethod2Interceptor interceptor = null;
		List<AroundMethod2Interceptor> interceptors = new ArrayList<AroundMethod2Interceptor>();
		if (CUSTOM_INTERCEPTOR_CLASS != null && CUSTOM_INTERCEPTOR_CLASS.length > 0) {
			for (int i = 0; i <= CUSTOM_INTERCEPTOR_CLASS.length; i++) {
				try {
					if (AroundMethod2Interceptor.class.isAssignableFrom(CUSTOM_INTERCEPTOR_CLASS[i])) {
						interceptor = (AroundMethod2Interceptor)CUSTOM_INTERCEPTOR_CLASS[i].newInstance();
						interceptors.add(interceptor);
					}
				} catch (Exception e) {
					throw new RuntimeException("MethodMonitorInterceptorImpl constructor error.", e);
				}
			}
			
			if (!interceptors.isEmpty() && interceptors.size() > 0) {
				method2InterceptorObjects = (AroundMethod2Interceptor[])interceptors.toArray(new AroundMethod2Interceptor[0]);
			}
			 
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#beforeInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void beforeInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		
		log.debug("MethodMonitorInterceptorImpl beforeInterceptor...");
		
		if (isFirstMethod()) {
			setFirstMethod();
			isFirstMethod = true;
		}
		
		// 服务控制
		
		// 服务路由
		
		// Trace
		
		// 自定义拦截器
		if (method2InterceptorObjects != null && method2InterceptorObjects.length > 0) {
			for (int i = 0; i < method2InterceptorObjects.length; i++) {
				try {
					method2InterceptorObjects[i].beforeInterceptor(obj, methodName, objectArray);
				} catch (Exception e) {
					throw new JupiterException("method2InterceptorObject beforeInterceptor has exception", e);
				}
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#afterInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void afterInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		log.debug("MethodMonitorInterceptorImpl afterInterceptor...");
		if (isFirstMethod) {
			clearFirstMethod();
		}
		
		if (method2InterceptorObjects != null && method2InterceptorObjects.length > 0) {
			for (int i = method2InterceptorObjects.length - 1; i >= 0; i--) {
				try {
					method2InterceptorObjects[i].afterInterceptor(obj, methodName, objectArray, methodReturnObj);
				} catch (Exception e) {
					log.error("method2InterceptorObject afterInterceptor has exception", e);
					throw new JupiterException("method2InterceptorObject afterInterceptor has exception", e);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#exceptionInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void exceptionInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		if (isFirstMethod) {
			clearFirstMethod();
		}
		
		if (method2InterceptorObjects != null && method2InterceptorObjects.length > 0) {
			for (int i = method2InterceptorObjects.length - 1; i >= 0; i--) {
				try {
					method2InterceptorObjects[i].exceptionInterceptor(obj, methodName, objectArray);
				} catch (Exception e) {
					throw new JupiterException("method2InterceptorObject exceptionInterceptor has exception", e);
				}
			}
		}
	}

	/**
	 * 是否入口方法
	 * 
	 * @return boolean
	 */
	private static boolean isFirstMethod() {
		Object obj = IS_FIRST_METHOD.get();
		if (obj == null || ((Boolean) obj).equals(Boolean.FALSE)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 设置入口方法
	 */
	private static void setFirstMethod() {
		IS_FIRST_METHOD.set(null);
		IS_FIRST_METHOD.set(Boolean.TRUE);
	}

	/**
	   *
	   */
	private static void clearFirstMethod() {
		IS_FIRST_METHOD.set(null);
	}
	
	/**
	 * 
	 * @Function: MethodMonitorInterceptorImpl.java
	 * @Description: 设置返回值
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 18 May 2016 16:49:37
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 18 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	public void setReturnObject(Object obj) {
		this.methodReturnObj = obj;
	}

}
