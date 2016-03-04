/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Defaults.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 18 Feb 2016 17:19:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 18 Feb 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.complex.xml.cfg.defaults;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Bin
 *
 */
public class Defaults {

	private List list = new ArrayList();

	private Transaction transaction;
	private Proxy proxy;
	private DataSource datasource;
	private Center center;
	private Interceptor interceptor;
	private TransactionInterceptor transactionInterceptor;
	
	public Defaults() {
		
	}
}
