/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: RealSubject.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月6日 下午5:27:36 
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
public class RealSubject implements Subject {

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.proxy.Subject#request()
	 */
	@Override
	public void request() {
		// TODO Auto-generated method stub
		System.out.println("do request......");
	}

}
