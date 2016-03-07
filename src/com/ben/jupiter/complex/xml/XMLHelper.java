/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: XMLHelper.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:06:04 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml;

import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ben.jupiter.common.Constants;
import com.ben.jupiter.complex.xml.cfg.caches.Accelerate;
import com.ben.jupiter.complex.xml.cfg.caches.Cache;
import com.ben.jupiter.complex.xml.cfg.caches.Caches;
import com.ben.jupiter.complex.xml.cfg.caches.Quartz;
import com.ben.jupiter.complex.xml.cfg.daos.Daos;
import com.ben.jupiter.complex.xml.cfg.defaults.Center;
import com.ben.jupiter.complex.xml.cfg.defaults.Clazz;
import com.ben.jupiter.complex.xml.cfg.defaults.Defaults;
import com.ben.jupiter.complex.xml.cfg.defaults.Interceptor;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;
import com.ben.jupiter.complex.xml.cfg.services.Services;
import com.ben.jupiter.exception.JupiterException;
import com.ben.jupiter.security.ResourceSafeCloseUtil;

/**
 * @author Yang Bin
 *
 */
public class XMLHelper {
	
	private transient static Log log = LogFactory.getLog(XMLHelper.class);
	
	private static XMLHelper instance = null;
	
	private static Defaults defaults = null;
	private static Caches caches = null;
	private static Services services = null;
	private static Daos daos = null;
	
	private static Boolean isInit = Boolean.FALSE;
	
	private static Boolean isServiceInit = Boolean.FALSE;
	private static Boolean isDaoInit = Boolean.FALSE;
	private static Boolean isCacheInit = Boolean.FALSE;
	
	private XMLHelper() {
		
	}
	
	/**
	 * 
	 * @Function: XMLHelper.java
	 * @Description: 单例模式
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 18 Feb 2016 17:34:30
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 18 Feb 2016     Yang Bin           v1.0.0               修改原因
	 */
	public static XMLHelper getInstance() throws Exception {
		if (isInit.equals(Boolean.FALSE)) {
			synchronized (isInit) {
				if (isInit.equals(Boolean.FALSE)) {
					defaults = createDefaults();
					isInit = Boolean.TRUE;
				}
			}
		}
		instance = new XMLHelper();
		return instance;
	}

	/**
	 * 
	 * @Function: XMLHelper.java
	 * @Description: 获取Cache.xml信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 7 Mar 2016 23:07:30
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 7 Mar 2016     Yang Bin           v1.0.0               修改原因
	 */
	public Caches getCaches() throws Exception {
		if (caches == null) {
			synchronized (isCacheInit) {
				if (isCacheInit.equals(Boolean.FALSE)) {
					caches = createCaches();
					isCacheInit = Boolean.TRUE;
				}
			}
		}
		return caches;
	}
	
	/**
	 * 
	 * @Function: XMLHelper.java
	 * @Description: 初始化Defaults配置文件
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 18 Feb 2016 17:34:51
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 18 Feb 2016     Yang Bin           v1.0.0               修改原因
	 */
	private static Defaults createDefaults() throws Exception {
		Defaults defaults = null;
		
		String defaultFileName = Constants.DEFAULTS_FILE_NAME;
		if (!StringUtils.isBlank(System.getProperty(Constants.D_DEFAULTS_FILE_NAME))) {
			defaultFileName = System.getProperty(Constants.D_DEFAULTS_FILE_NAME).trim();
			log.debug("default file name:" + defaultFileName);
		}
		
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(defaultFileName);
			if (input == null) {
				throw new JupiterException("read file [" + defaultFileName + "] failed!");
			}
			
			Digester digester = new Digester();
			digester.setValidating(false);
			digester.addObjectCreate("defaults", Defaults.class.getName());
			digester.addSetProperties("defaults");
			
			// 中心配置
			digester.addObjectCreate("defaults/center", Center.class.getName());
			digester.addSetProperties("defaults/center");
			
			digester.addObjectCreate("defaults/center/property", Property.class.getName());
			digester.addSetProperties("defaults/center/property");
			
			// 拦截器配置
			digester.addObjectCreate("defaults/interceptor", Interceptor.class.getName());
			digester.addSetProperties("defaults/interceptor");
			
			digester.addObjectCreate("defaults/interceptor/clazz", Clazz.class.getName());
			digester.addSetProperties("defaults/interceptor/clazz");
			
			digester.addObjectCreate("defaults/interceptor/clazz/property", Property.class.getName());
			digester.addSetProperties("defaults/interceptor/clazz/property");
			
			
//			defaults = (Defaults) digester.parse(input);
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				ResourceSafeCloseUtil.safeClose(input);
			}
		}
		
		return defaults;
	}
	
	/**
	 * 
	 * @Function: XMLHelper.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 18 Feb 2016 17:41:05
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 18 Feb 2016     Yang Bin           v1.0.0               修改原因
	 */
	private static Caches createCaches() throws Exception {
		Caches caches = null;
		
		String cacheFileName = Constants.CACHE_FILE_NAME;

		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(cacheFileName);
			if (input == null) {
				throw new JupiterException("read file [" + cacheFileName + "] failed!");
			}
			
			Digester digester = new Digester();
			digester.setValidating(false);
			
			digester.addObjectCreate("caches", Caches.class.getName());
			digester.addSetProperties("caches");
			
			// 定时刷新缓存任务配置
			digester.addObjectCreate("caches/quartz", Quartz.class.getName());
			digester.addSetProperties("caches/quartz");
			
			digester.addObjectCreate("caches/quartz/property", Property.class.getName());
			digester.addSetProperties("caches/quartz/property");
			
			digester.addObjectCreate("caches/accelerate", Accelerate.class.getName());
			digester.addSetProperties("caches/accelerate");
			
			digester.addObjectCreate("caches/accelerate/property", Property.class.getName());
			digester.addSetProperties("caches/accelerate/property");
			
			digester.addObjectCreate("caches/cache", Cache.class.getName());
			digester.addSetProperties("caches/cache");
			
			digester.addObjectCreate("caches/cache/property", Property.class.getName());
			digester.addSetProperties("caches/cache/property");
			
			// 值设置
			digester.addSetNext("caches/quartz", "setQuartz", Quartz.class.getName());
			digester.addSetNext("caches/quartz/property", "addProperty", Property.class.getName());
			
			digester.addSetNext("caches/accelerate", "setAccelerate", Accelerate.class.getName());
			digester.addSetNext("caches/accelerate/property", "addProperty", Property.class.getName());
			
			digester.addSetNext("caches/cache", "setCache", Cache.class.getName());
			digester.addSetNext("caches/cache/property", "addProprety", Property.class.getName());
			
			caches = (Caches)digester.parse(input);
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				ResourceSafeCloseUtil.safeClose(input);
			}
		}
		
		return caches;
	}
	
	
}
