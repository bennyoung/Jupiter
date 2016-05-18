/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: MiscHelper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 22 Mar 2016 21:19:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 22 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.service.ServiceNameBuilderFactory;

/**
 * @author Yang Bin
 *
 */
public class MiscHelper {
	
	private transient static Log log = LogFactory.getLog(MiscHelper.class);
	
	private MiscHelper() {
		
	}
	
	/**
	 * 
	 * @Function: MiscHelper.java
	 * @Description: 根据接口获取实现类
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 22 Mar 2016 21:20:36
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 22 Mar 2016     Yang Bin           v1.0.0               修改原因
	 */
	public static Class getImplClassByInterClassName(Class interfaceClass) throws Exception {
		String implClassName = ServiceNameBuilderFactory.getServiceNameBuilder().createStandService(interfaceClass);
		Class clazz = Class.forName(implClassName);
		return clazz;
	}
	
	/**
	 * 
	 * @Function: MiscHelper.java
	 * @Description: 根据接口获取实现类
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 23 Mar 2016 10:29:39
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 23 Mar 2016     Yang Bin           v1.0.0               修改原因
	 */
	public static Class getImplClassByInterClassName(String interfaceClassName) throws Exception {
		String implClassName = ServiceNameBuilderFactory.getServiceNameBuilder().createStandService(interfaceClassName);
		Class clazz = Class.forName(implClassName);
		return clazz;
	}

}
