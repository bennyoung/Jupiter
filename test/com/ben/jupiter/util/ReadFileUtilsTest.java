/**   
 * Copyright: Copyright (c) 2015 Asiainfo
 * 
 * @ClassName: ReadFileUtilsTest.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Yang Bin
 * @date: 17 Nov 2015 14:37:03 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 17 Nov 2015     Yang Bin           v1.0.0               修改原因
 */
package com.ben.jupiter.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.junit.Test;

/**
 * @author Yang Bin
 * 
 */
public class ReadFileUtilsTest {

	@Test
	public void readFile() throws Exception {
		String specialsvPath = "special_sv.properties";
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(specialsvPath);
		if (input != null) {
			Properties p = new Properties();
			p.load(input);
			Iterator its=p.keySet().iterator();
			while (its.hasNext()){
				String itemKey=(String)its.next();
				String itemValue=(String)p.get(itemKey);
				System.out.println("Special Service key:["+itemKey+"],value:["+itemValue+"]");
			}
		}

	}

}
