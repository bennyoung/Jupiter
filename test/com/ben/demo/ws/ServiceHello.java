/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ServiceHello.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 24 May 2016 19:53:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 24 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.ws;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author Yang Bin
 *
 */
@WebService
public class ServiceHello {

	public String getValue(String name) {
		return "I'm " + name;
	}
	
	public static void main(String args[]) throws Exception {
		Endpoint.publish("http://localhost:9001/Service/ServiceHello", new ServiceHello());
		System.out.println("service success!");
	}
	
}
