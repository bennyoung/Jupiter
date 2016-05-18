/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: YieldExample.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 16 May 2016 22:14:06 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 16 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.thread;

/**
 * @author Yang Bin
 *
 */
public class YieldExample extends Thread {

	public void run() {
		long beginTime=System.currentTimeMillis();
        int count=0;
        for (int i=0;i<5000;i++){
            count=count+(i+1);
            System.out.println("yield:" + i);
//            Thread.yield();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("用时："+(endTime-beginTime)+" 毫秒！");
	}
	
	public static void main(String[] args) {
		YieldExample y = new YieldExample();
		y.start();
		for (int i=0;i<5000;i++) {
			System.out.println("main:" + i);
		}
	}
	
}
