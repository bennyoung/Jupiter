/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: IMutilTransactionDatasource.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月16日 上午9:39:40 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月16日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datasource.interfaces;

/**
 * @author Ben
 *
 */
public interface IMutilTransactionDatasource {

	public void setCurDataSource(String ds);
	
	public String getCurDataSource();
	
}
