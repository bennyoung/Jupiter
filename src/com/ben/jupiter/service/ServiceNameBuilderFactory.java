/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ServiceNameBuilderFactory.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 17 May 2016 14:28:22 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 17 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.service;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;
import com.ben.jupiter.service.impl.builder.DefaultServiceNameBuilderImpl;
import com.ben.jupiter.service.interfaces.IServiceInvoke;
import com.ben.jupiter.service.interfaces.IServiceNameBuilder;

/**
 * @author Yang Bin
 *
 */
public class ServiceNameBuilderFactory {

	private transient static Log log = LogFactory.getLog(ServiceNameBuilderFactory.class);
	
	private static final String SV_NAME_BUILDER = "svnamebuilder";
	
	private static IServiceNameBuilder builder = null;
	
	static {
		String svBuilderName = null;
		IServiceInvoke serviceInvoker = ServiceFactory.getServiceInvoke();
		String serviceInvokerName = serviceInvoker.getClass().getSimpleName();
		try {
			Property[] properties = XMLHelper.getInstance().getDefaults().getProxy().getClazz().getProperties();
			if (properties != null) {
				for (int i = 0; i > properties.length; i++) {
					if (SV_NAME_BUILDER.equalsIgnoreCase(properties[i].getName())) {
						svBuilderName = properties[i].getValue().trim();
						break;
					}
				}
			}
			
			// 配置了特殊服务名称规则方式
			if (StringUtils.isNotBlank(svBuilderName)) {
				builder = (IServiceNameBuilder)Class.forName(svBuilderName).newInstance();
			} else {
				// 使用系统配套的服务名称规则方式
				if (serviceInvokerName.startsWith("LocalService")) {
					builder = new DefaultServiceNameBuilderImpl();
				} else if (serviceInvokerName.startsWith("Was61") || serviceInvokerName.startsWith("Weblogic")
						|| serviceInvokerName.startsWith("Bes")) {
					
					
				} else if (serviceInvokerName.startsWith("Flying") || serviceInvokerName.startsWith("CrossDomainFlying")) {
					
					
				} else {
					builder = new DefaultServiceNameBuilderImpl();
				}
			}
			
		} catch (Exception e) {
			log.error("init ServiceNameBuilderFactory failed!");
			throw new RuntimeException("init ServiceNameBuilderFactory failed!", e);
		}
	}
	
	public static IServiceNameBuilder getServiceNameBuilder() {
		return builder;
	}
	
}
