/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: SleepInterrupt.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 23 Mar 2016 14:12:39 
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
public class SleepInterrupt implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			System.out.println("interrupt--- in interrupt thread.");
			Thread.yield();
			Thread.sleep(20000);
			System.out.println("interrupt--- sleep interrupt thread.");
		} catch (InterruptedException e) {
			System.out.println("interrupt--- catch");
			return;
		}
		System.out.println("interrupt--- return");
	}

	public static void main(String[] args) {
		SleepInterrupt si = new SleepInterrupt();
		Thread t = new Thread(si);
		t.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main---- interrupt other thread.");
		t.interrupt();
		System.out.println("main---- interrupt after.");
		
		System.out.println("Thread.interrupt-----" + Thread.interrupted());
		Thread.currentThread().interrupt();
		System.out.println("Thread.interrupt-----" + Thread.interrupted());
		System.out.println("Thread.interrupt-----" + Thread.interrupted());
	}
	
}
