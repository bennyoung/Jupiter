/**   
* Copyright: Copyright (c) 2015 Asiainfo
* 
* @ClassName: ServiceFactory.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Jul 2015 11:42:37 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Jul 2015     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.service.interfaces.IServiceInvoke;

/**
 * @author Yang Bin
 *
 */
public class ServiceFactory {

	private transient static Log log = LogFactory.getLog(ServiceFactory.class);
	
	private static IServiceInvoke serviceInvoke = null;
	
	static {
		try {
			String serviceName = XMLHelper.getInstance().getDefaults().getProxy().getClazz().getName().trim();
			if (StringUtils.isNotBlank(serviceName)) {
				serviceInvoke = (IServiceInvoke)Class.forName(serviceName).newInstance();
			} else {
				throw new JupiterException("service name is null!");
			}
			
			// TODO:MBean注册
			
			
		} catch (Exception e) {
			throw new RuntimeException("init ServiceFactory error!", e);
		}
		
	}
	
	/**
	 * 
	 * @Function: ServiceFactory.java
	 * @Description: 获取服务对象实例
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 8 Mar 2016 22:11:24
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 8 Mar 2016     Yang Bin           v1.0.0               修改原因
	 */
	public static <BEN> BEN getService(Class<BEN> interfaceClass) {
		return serviceInvoke.getService(interfaceClass);
	}
	
	public static IServiceInvoke getServiceInvoke() {
		return serviceInvoke;
	}
	
	public static void main(String args[]) throws Exception {
		log.error("this is ServiceFactory: test log error.");
	}
}
