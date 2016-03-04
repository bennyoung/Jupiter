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
import com.ben.jupiter.complex.xml.cfg.caches.Caches;
import com.ben.jupiter.complex.xml.cfg.daos.Daos;
import com.ben.jupiter.complex.xml.cfg.defaults.Defaults;
import com.ben.jupiter.complex.xml.cfg.services.Services;
import com.ben.jupiter.exception.JupiterException;

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
		if (StringUtils.isBlank(System.getProperty(Constants.D_DEFAULTS_FILE_NAME))) {
			defaultFileName = System.getProperty(Constants.D_DEFAULTS_FILE_NAME).trim();
			log.debug("default file name:" + defaultFileName);
		}
		
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(defaultFileName);
			if (input == null) {
				throw new JupiterException("read file failed!");
			}
			
			Digester digester = new Digester();
			digester.setValidating(false);
			
			
		} catch (Exception e) {
			throw e;
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
		
		return caches;
	}
	
	
}
