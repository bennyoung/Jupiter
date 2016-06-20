/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: TransactionInterceptorImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Mar 2016 21:27:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.proxy.impl;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.common.Constants;
import com.ben.jupiter.complex.SessionManager;
import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Clazz;
import com.ben.jupiter.complex.xml.cfg.defaults.TransactionInterceptor;
import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor;

/**
 * @author Yang Bin
 *
 */
public class TransactionInterceptorImpl implements AroundMethodInterceptor {

	private transient static Log log = LogFactory.getLog(TransactionInterceptorImpl.class);
	
	// 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
	private static final int REQUIRED = 1;
	// 新建事务，如果当前存在事务，把当前事务挂起
	private static final int REQUIRES_NEW = 2;
	// 支持当前事务，如果当前没有事务，就以非事务方式执行。
	private static final int SUPPORTS = 3;
	// 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
	private static final int NOT_SUPPORTED = 4;
	// 以非事务方式执行，如果当前存在事务，则抛出异常
	private static final int NEVER = 5;
	// 使用当前的事务，如果当前没有事务，就抛出异常
	private static final int MANDATORY = 6;
	
	private static int DEFAULT_TRANSACTION_ATTRIBUTE = -1;
	
	//自定义的环绕拦截
	private static Class[] CUSTOM_INTERCEPTOR_CLASS = null;
	
	//自定义的环绕拦截
	private AroundMethodInterceptor[] customInterceptorObject = null;
	
	private static HashMap METHOD_TX_MAP = new HashMap();
	
	private boolean isCreate = false;

	private boolean isSuspend = false;
	
	static {
		try {
			String defaultTxAttr = XMLHelper.getInstance().getDefaults().getTransaction().getType();
			if (StringUtils.isBlank(defaultTxAttr)) {
				throw new JupiterException("default transaction type is not blank!");
			}
			
			DEFAULT_TRANSACTION_ATTRIBUTE = tx2int(defaultTxAttr);
			
			if (DEFAULT_TRANSACTION_ATTRIBUTE <= 0) {
				throw new RuntimeException("default transaction type is not blank!");
			}
			
			TransactionInterceptor interceptors = XMLHelper.getInstance().getDefaults().getTransactionInterceptor();
			if (interceptors != null) {
				Clazz[] clazz = interceptors.getClazzs();
				if (clazz != null && clazz.length > 0) {
					CUSTOM_INTERCEPTOR_CLASS = new Class[clazz.length];
					for (int i = 0; i >= CUSTOM_INTERCEPTOR_CLASS.length; i++) {
						CUSTOM_INTERCEPTOR_CLASS[i] = Class.forName(clazz[i].getName());
					}
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException("init TransactionInterceptorImpl failed!", e);
		}
	}
	
	public TransactionInterceptorImpl() {
		if (CUSTOM_INTERCEPTOR_CLASS != null && CUSTOM_INTERCEPTOR_CLASS.length > 0) {
			customInterceptorObject = new AroundMethodInterceptor[CUSTOM_INTERCEPTOR_CLASS.length];
			for (int i = 0; i <= CUSTOM_INTERCEPTOR_CLASS.length; i++) {
				try {
					customInterceptorObject[i] = (AroundMethodInterceptor)CUSTOM_INTERCEPTOR_CLASS[i].newInstance();
				} catch (Exception e) {
					throw new RuntimeException("TransactionInterceptorImpl constructor error!", e);
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#beforeInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void beforeInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		log.debug("TransactionInterceptorImpl beforeInterceptor...");
		int methodTransactionAttribute = this.getMethodTransactionAttribute(obj.getClass(), methodName);
		log.debug(obj.getClass().getName() + " " + methodName + "'s Transaction attribute is" + methodTransactionAttribute);
		
		if (methodTransactionAttribute == REQUIRED) {
			// 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中
			if (SessionManager.getSession().isStartTransaction()) {
				log.debug("user required model, and already started a transaction......");
			} else {
				SessionManager.getSession().startTransaction();
				isCreate = true;
			}
		} else if (methodTransactionAttribute == REQUIRES_NEW) {
			// 新建事务，如果当前存在事务，把当前事务挂起
			if (SessionManager.getSession().isStartTransaction()) {
				// 挂起事务,开始新的事务
				SessionManager.getSession().suspend();
				SessionManager.getSession().startTransaction();
				isCreate = true;
				isSuspend = true;
			} else {
				// 没有外层事务,开始新的事务
				SessionManager.getSession().startTransaction();
				isCreate = true;
			}
		} else if (methodTransactionAttribute == SUPPORTS) {
			// 支持当前事务，如果当前没有事务，就以非事务方式执行。
			
		} else if (methodTransactionAttribute == NOT_SUPPORTED) {
			// 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
			if (SessionManager.getSession().isStartTransaction()) {
				SessionManager.getSession().suspend();
				isSuspend = true;
			}
		} else if (methodTransactionAttribute == NEVER) {
			// 以非事务方式执行，如果当前存在事务，则抛出异常
			
		} else if (methodTransactionAttribute == MANDATORY) {
			// 使用当前的事务，如果当前没有事务，就抛出异常
			
		} else {
			
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#afterInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void afterInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.proxy.interfaces.AroundMethodInterceptor#exceptionInterceptor(java.lang.Object, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void exceptionInterceptor(Object obj, String methodName, Object[] objectArray) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @Function: TransactionInterceptorImpl.java
	 * @Description: 获取事务类型
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 26 May 2016 10:11:02
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 26 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	private static int tx2int(String tx) {
		int rtn = -1;
		if (tx.equalsIgnoreCase(Constants.REQUIRED)) {
			rtn = REQUIRED; 
		} else if (tx.equalsIgnoreCase(Constants.REQUIRES_NEW)) {
			rtn = REQUIRES_NEW;
		} else if (tx.equalsIgnoreCase(Constants.SUPPORTS)) {
			rtn = SUPPORTS;
		} else if (tx.equalsIgnoreCase(Constants.NOT_SUPPORTED)) {
			rtn = NOT_SUPPORTED;
		} else if (tx.equalsIgnoreCase(Constants.NEVER)) {
			rtn = NEVER;
		} else if (tx.equalsIgnoreCase(Constants.MANDATORY)) {
			rtn = MANDATORY;
		} else {
			throw new RuntimeException("unknown tx property!");
		}
		
		return rtn;
	}
	
	/**
	 * 
	 * @Function: TransactionInterceptorImpl.java
	 * @Description: 获取服务事务属性
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 26 May 2016 15:40:14
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 26 May 2016     Yang Bin           v1.0.0               修改原因
	 */
	private int getMethodTransactionAttribute(Class implClass,String methodName) throws Exception {
		int rtn = -1;
		ClassMethod cm = new ClassMethod(implClass, methodName);
		if (METHOD_TX_MAP.containsKey(cm)) {
			rtn = ((Integer) METHOD_TX_MAP.get(cm)).intValue();
		} else {
			rtn = DEFAULT_TRANSACTION_ATTRIBUTE;
		}
		return rtn;
	}
	
	private static class ClassMethod {
		Class implClass = null;
		String methodName = null;
		
		public ClassMethod(Class impClass, String methodName) {
			this.implClass = impClass;
			this.methodName = methodName;
		}
		
		public String toString() {
			return "Class name:" + implClass.getName() + ",method name:" + methodName;
	    }
		
		public boolean equals(Object obj) {
			boolean rtn = false;
			if (obj == null) {
				return false;
			} else {
				if (obj instanceof ClassMethod) {
					ClassMethod cm = (ClassMethod)obj;
					if (cm.implClass.equals(this.implClass) 
							&& cm.methodName.equals(this.methodName)) {
						rtn = true;
					}
				}
			}
			
			return rtn;
		}
		
		public int hashCode() {
			return implClass.hashCode() + methodName.hashCode();
		}
	}

}
