/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ProxyTest.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月7日 下午3:09:05 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月7日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.proxy.examlpe1;

import org.junit.Test;

/**
 * @author Ben
 *
 */
public class ProxyTest {

	@Test
	public void proxyTest() {
		RealSubject rs = new RealSubject();
		ProxySubject ps = (ProxySubject)ProxyFactory.getProxy(rs);
		ps.request();
	}
	
}
