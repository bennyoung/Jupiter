/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: CallableExample.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 16 May 2016 14:32:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 16 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Yang Bin
 *
 */
public class CallableExample {

	public static void main(String[] args) {
		Callable<Integer> call = new Callable<Integer>() {
			public Integer call() throws Exception {
				System.out.println("inside callable");
				Thread.sleep(1000);
				return new Integer(8);
			}
			
		};
		
		FutureTask<Integer> task = new FutureTask<Integer>(call);
		Thread thread = new Thread(task);
		thread.start();
		
		
		try {
			System.out.println("start main....");
			System.out.println(task.get());
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("end main....");
		}
		
	}
	
}
