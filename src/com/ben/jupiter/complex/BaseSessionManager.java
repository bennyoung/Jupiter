/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: BaseSessionManager.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月13日 下午1:46:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.complex;

import java.lang.reflect.Constructor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.transaction.interfaces.Session;

/**
 * @author Yang Bin
 *
 */
public class BaseSessionManager {

	private transient static Log log = LogFactory.getLog(BaseSessionManager.class);
	
	private static Constructor m_session = null;
	
	private static ThreadLocal s_session = new ThreadLocal() {
		
		public Object initialValue() {
			Object result = null;
			try {
				result = m_session.newInstance(new Object[0]);
			} catch (Exception ex) {
				if (ex instanceof RuntimeException)
					throw (RuntimeException) ex;
				else
					throw new RuntimeException(ex);
			}
			return result;
		}
		
	};
	
	/**
	 * initial
	 */
	static {
		initial();
	}
	
	public static void initial() {
		try {
			if (XMLHelper.getInstance().getDefaults().getTransaction() != null &&
					  !StringUtils.isBlank(XMLHelper.getInstance().getDefaults().getTransaction().getClazz().getName())) {
				m_session = Class.forName(XMLHelper.getInstance().getDefaults().getTransaction().getClazz().getName().trim()).getConstructor(new Class[0]);
			}
		} catch (Exception e) {
			log.error("init BaseSessionManager error.", e);
			if (e instanceof RuntimeException) {
				throw (RuntimeException)e;
			} else {
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * 获取一个线程级对象管理器
	 * 
	 * @return Session
	 */
	public static Session getSession() {
		return (Session) s_session.get();
	}
	
	/**
	 * setSession
	 * @param session Session
	 */
	public static void setSession(Session session) {
		s_session.set(session);
	}
}
