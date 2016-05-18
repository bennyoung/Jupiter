/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: LocalServiceInvokeImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 19 Feb 2016 10:53:04 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 19 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.proxy.ProxyInvocationHandler;
import com.ben.jupiter.proxy.impl.MethodMonitorInterceptorImpl;
import com.ben.jupiter.proxy.impl.TransactionDataSourceInterceptorImpl;
import com.ben.jupiter.proxy.impl.TransactionInterceptorImpl;
import com.ben.jupiter.service.interfaces.ISelfManagedService;
import com.ben.jupiter.service.interfaces.ISelfManagedServiceWithRequiredTransaction;
import com.ben.jupiter.service.interfaces.IServiceInvoke;
import com.ben.jupiter.util.MiscHelper;
import com.ben.jupiter.util.ProxyUtil;

/**
 * @author Yang Bin
 *
 */
public class LocalServiceInvokeImpl implements IServiceInvoke {
	
	private transient static Log log = LogFactory.getLog(LocalServiceInvokeImpl.class);
	
	private static final String DAO = "DAO";
	private static final String SV = "SV";
	
	static {
		
	}
	
	public LocalServiceInvokeImpl() {
		
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.service.interfaces.IServiceInvoke#getService(java.lang.Class)
	 */
	@Override
	public Object getService(Class interfaceClass) {
		Object rtn = null;
		try {
			String interfaceName = interfaceClass.getName();
			if (StringUtils.lastIndexOf(interfaceName, DAO) != -1) {
				rtn = this.getDAOObject(interfaceClass, MiscHelper.getImplClassByInterClassName(interfaceClass));
			} else if (StringUtils.lastIndexOf(interfaceName, SV) != -1) {
				rtn = this.getSVObject(interfaceClass, MiscHelper.getImplClassByInterClassName(interfaceClass));
			} else {
				throw new JupiterException("invoke Object getservice(Class interfaceClass) error.");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return rtn;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.service.interfaces.IServiceInvoke#getService(java.lang.String)
	 */
	@Override
	public Object getService(String interfaceClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.service.interfaces.IServiceInvoke#getCrossCenterService(java.lang.Class)
	 */
	@Override
	public Object getCrossCenterService(Class interfaceClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.service.interfaces.IServiceInvoke#getCrossCenterService(java.lang.String)
	 */
	@Override
	public Object getCrossCenterService(String interfaceClass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @Function: LocalServiceInvokeImpl.java
	 * @Description: 获取代理后的服务对象
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 22 Mar 2016 22:12:09
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 22 Mar 2016     Yang Bin           v1.0.0               修改原因
	 */
	private Object getSVObject(Class interfaceClass, Class implClass) throws Exception {
		Object rtn = implClass.newInstance();
		
		Class[] clazz = null;
		if (!(rtn instanceof ISelfManagedService) && !(rtn instanceof ISelfManagedServiceWithRequiredTransaction)) {
			clazz = new Class[] {
					MethodMonitorInterceptorImpl.class,
					TransactionInterceptorImpl.class,
					TransactionDataSourceInterceptorImpl.class
			};
		} else {
			if (rtn instanceof ISelfManagedService) {
				clazz = new Class[] {
						MethodMonitorInterceptorImpl.class
				};
			} else if (rtn instanceof ISelfManagedServiceWithRequiredTransaction) {
				clazz = new Class[] {
						MethodMonitorInterceptorImpl.class,
						TransactionInterceptorImpl.class
				};
			} else {
				throw new RuntimeException("there is no type of class [" + rtn.getClass().getName() + "]");
			}
		}
		ProxyInvocationHandler handler = new ProxyInvocationHandler(rtn, clazz);
		
		// 不使用Proxy.newProxyInstance(loader, interfaces, h),因为每次都会调用getProxyClass
		rtn = ProxyUtil.getProxyObject(implClass.getClassLoader(), new Class[] {interfaceClass}, handler);
		
		return rtn;
	}
	
	/**
	 * 
	 * @Function: LocalServiceInvokeImpl.java
	 * @Description: 获取代理后的DAO对象
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 22 Mar 2016 22:12:23
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 22 Mar 2016     Yang Bin           v1.0.0               修改原因
	 */
	private Object getDAOObject(Class interfaceClass, Class implClass) throws Exception {
		Object rtn = null;
		
		return rtn;
	}

}
