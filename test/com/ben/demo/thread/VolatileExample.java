/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: VolatileExample.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 13 May 2016 10:23:33 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 13 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.thread;

/**
 * @author Yang Bin
 *
 */
public class VolatileExample implements Runnable {

	private static volatile boolean flag = false;
	
	public void run() {
		while(!flag) {
		}
		System.out.println("stopped!");
	}
	
	public static void main(String[] args) throws Exception {
		new Thread(new VolatileExample()).start();
		Thread.sleep(100);
		flag = true;
	}
	
}
