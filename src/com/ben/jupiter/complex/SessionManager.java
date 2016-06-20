/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: SessionManager.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月13日 下午2:23:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.complex;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.transaction.interfaces.Session;

/**
 * @author Ben
 *
 */
public class SessionManager {

	private transient static Log log = LogFactory.getLog(SessionManager.class);
	
	/**
	 * 
	 * @Function: SessionManager.java
	 * @Description: 获取线程级对象管理器
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Ben
	 * @date: 2016年6月13日 下午3:23:38
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2016年6月13日     Ben           v1.0.0               修改原因
	 */
	public static Session getSession() {
		return BaseSessionManager.getSession();
	}
	
}
