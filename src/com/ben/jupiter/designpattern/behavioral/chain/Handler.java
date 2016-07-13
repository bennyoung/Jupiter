/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Handler.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月5日 下午4:26:04 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月5日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.chain;

import java.util.List;

/**
 * @author Ben
 *
 */
public abstract class Handler {

	protected Handler handler = null;

	/**
	 * @return the handle
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * @param handle the handle to set
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public abstract List<Email> doSearch(List<Email> list);
	
}
