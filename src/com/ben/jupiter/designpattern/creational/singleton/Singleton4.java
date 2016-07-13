/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: SIngleton4.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月13日 下午4:54:46 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.creational.singleton;

/**
 * @author Ben
 *
 */
public enum Singleton4 {

	singleton;
	
	private SingletonTest s;
	
	private Singleton4() {
		s = new SingletonTest();
	}
	
	public SingletonTest getSingletonTest() {
		return s;
	}
	
}
