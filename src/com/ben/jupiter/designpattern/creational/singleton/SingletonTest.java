/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: SingletonTest.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月13日 下午3:13:53 
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
public class SingletonTest {

	public static void main(String[] args) {
		
//		MyThread thread = null;
//		for (int i = 0; i < 10; i++) {
//			thread = new MyThread();
//			thread.start();
//		}
		
		MyThread2 thread2 = new MyThread2();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(thread2);
			t.start();
		}
		
	}
	
}

class MyThread extends Thread {
	
	public void run() {
		System.out.println(Singleton2.getInstance().hashCode());
		System.out.println(Singleton4.singleton.getSingletonTest());
	}
	
}

class MyThread2 implements Runnable {
	public void run() {
		try {
			System.out.println(Singleton1.getInstance3().hashCode());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}