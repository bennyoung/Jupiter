/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: MyThread.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 23 Mar 2016 11:05:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 23 Mar 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.thread;

/**
 * @author Yang Bin
 *
 */
public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		MyThread2 rt = new MyThread2();
		for (int i = 0; i < 10; i++) {
//			new MyThread1().start();
			new Thread(rt).start();
			new Thread(rt).setDaemon(true);
		}
		
	}
	
}

class MyThread1 extends Thread {
	
	private volatile int firstVal;
	private volatile int secondVal;
	
	private int t = 5;
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (t > 0) {
				System.out.println("remain ticket:" + t);
				t--;
			}
			
		}
	}
	
}

class MyThread2 implements Runnable {

	private int t = 5;
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
//			synchronized (this) {
				if (t > 0) {
					System.out.println("remain ticket:" + t);
					t--;
				}
//			}
			
		}
		
	}
	
}