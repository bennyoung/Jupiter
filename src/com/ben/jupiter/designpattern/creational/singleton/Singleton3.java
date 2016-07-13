/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Singleton3.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月13日 下午4:23:45 
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
public class Singleton3 {

	private static class SingletonHander {
		public static Singleton3 s = new Singleton3();
	}
	
	private Singleton3() {
		
	}
	
	public static Singleton3 getInstance() {
		return SingletonHander.s;
	}
	
	private static Singleton3 s2 = null;
	static {
		s2 = new Singleton3();
	}
}
