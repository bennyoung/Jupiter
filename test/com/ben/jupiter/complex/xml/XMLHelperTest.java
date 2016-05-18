/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: XMLHelperTest.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:18:13 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.ben.jupiter.complex.xml.cfg.caches.Cache;
import com.ben.jupiter.complex.xml.cfg.caches.Caches;
import com.ben.jupiter.complex.xml.cfg.defaults.Defaults;
import com.ben.jupiter.complex.xml.cfg.defaults.Property;

/**
 * @author Yang Bin
 *
 */
public class XMLHelperTest {
	
	private transient static Log logger = LogFactory.getLog(XMLHelperTest.class);

	@Test
	public void createCachesTest() {
		try {
			Caches caches = XMLHelper.getInstance().getCaches();
			Cache[] cache = caches.getCaches();
			for (Cache c : cache) {
				System.out.println(c.getId());
				System.out.println(c.getInit());
				Property[] property = c.getPropertys();
				for (Property p : property) {
					System.out.println(p.getName());
				}
				System.out.println("-----------------");
			}
		} catch (Exception e) {
			logger.error("error content:", e);
		}
		
	}
	
	@Test
	public void createDefaultsTest() throws Exception {
		Defaults defaults = XMLHelper.getInstance().getDefaults();
		System.out.println(defaults.getProxy().getClazz().getName());
	}
	
}
