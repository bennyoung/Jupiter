/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: CreateSubjectFactory.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月7日 下午2:58:33 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月7日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.proxy.examlpe1;

/**
 * @author Ben
 *
 */
public class ProxyFactory {

	public static Subject getProxy(RealSubject subject) {
		ProxySubject proxy = new ProxySubject();
		proxy.setSubject(subject);
		return proxy;
	}
	
}
