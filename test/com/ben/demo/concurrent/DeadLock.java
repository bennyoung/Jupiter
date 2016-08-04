/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: DeadLock.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月29日 下午4:13:52 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月29日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.concurrent;

/**
 * @author Ben
 *
 */
public class DeadLock {

	private String objName;
	
	public DeadLock(String objName) {
		this.objName = objName;
	}
	
	public synchronized void checkOther(DeadLock other) { 
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		other.action();
	}
	
	public synchronized void action() {
		try {
			Thread.sleep(500);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print(String msg) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ":" + msg);
	}
	
}
