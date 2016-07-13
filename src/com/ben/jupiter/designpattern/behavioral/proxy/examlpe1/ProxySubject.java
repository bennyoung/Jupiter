/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ProxySubject.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月6日 下午5:34:14 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月6日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.proxy.examlpe1;

/**
 * @author Ben
 *
 */
public class ProxySubject implements Subject {
	
	private Subject rs;
	
	public void setSubject(Subject rs) {
		this.rs = rs;
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.proxy.Subject#request()
	 */
	@Override
	public void request() {
		System.out.println("before request.....");
		rs.request();
		System.out.println("after request.....");
	}

}
