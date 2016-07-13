/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Singleton1.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月13日 下午2:59:03 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月13日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.creational.singleton;

/**
 * @author Ben
 * 懒汉模式
 */
public class Singleton1 {

	private static Singleton1 s;
	
	private Singleton1() {
		
	}
	
	synchronized public static Singleton1 getInstance() {
		if (s == null) {
			s = new Singleton1();
		}
		return s;
	}
	
	public static Singleton1 getInstance2() {
		synchronized (Singleton1.class) {
			if (s == null) {
				s = new Singleton1();
			}
		}
		return s;
	}
	
	public static Singleton1 getInstance3() throws InterruptedException {
		if (s == null) {
			Thread.sleep(5000);
			synchronized (Singleton1.class) {
				s = new Singleton1();
			}
		}
		return s;
	}
	
	public static Singleton1 getInstance4() {
		if (s == null) {
			synchronized (Singleton1.class) {
				if (s == null) {
					s = new Singleton1();
				}
			}
		}
		return s;
	}
	
}
