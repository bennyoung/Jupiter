/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Singleton2.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月13日 下午3:02:07 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.creational.singleton;

/**
 * @author Ben
 * 饿汉模式
 */
public class Singleton2 {

	private static Singleton2 s2 = new Singleton2();
	
	private Singleton2() {
		
	}
	
	public static Singleton2 getInstance() {
		return s2;
	}
	
}
