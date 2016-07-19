/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: DataSourceFactory.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月14日 下午5:36:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月14日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datasource;

import com.ben.jupiter.complex.xml.XMLHelper;
import com.ben.jupiter.datasource.interfaces.IDataSource;

/**
 * @author Ben
 *
 */
public class DataSourceFactory {

	private static IDataSource dataSource = null;
	
	static {
		try {
			String dsClassName = XMLHelper.getInstance().getDefaults().getDatasource().getClazz().getName().trim();
			dataSource = (IDataSource)Class.forName(dsClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("init DataSourceFactory error.");
		}
	}
	
	public static IDataSource getDataSource() {
		return dataSource;
	}
	
}
