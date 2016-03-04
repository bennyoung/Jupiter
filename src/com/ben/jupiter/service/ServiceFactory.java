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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.service.interfaces.IServiceInvoke;

/**
 * @author Yang Bin
 *
 */
public class ServiceFactory {

	private transient static Log log = LogFactory.getLog(ServiceFactory.class);
	
	private static IServiceInvoke objIServiceInvoke = null;
	
	static {
		
	}
	
	public static void main(String args[]) throws Exception {
		log.error("this is ServiceFactory: test log error.");
	}
}
