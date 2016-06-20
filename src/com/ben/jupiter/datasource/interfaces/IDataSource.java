/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: IDataSource.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月13日 下午4:48:53 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datasource.interfaces;

import java.sql.Connection;

/**
 * @author Yang Bin
 *
 */
public interface IDataSource {

	/**
	 * 当前的数据源
	 */
	public static final ThreadLocal CUR_DATASOURCE = new ThreadLocal();

	/**
	 * 从指定的数据源获得数据库连接
	 * @param ds String
	 * @throws Exception
	 * @return Connection
	 */
	public Connection getConnectionFromDataSource(String ds) throws Exception;
	
}
