/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Client.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月28日 下午3:06:34 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月28日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.observer;

/**
 * @author Ben
 *
 */
public class Client {

	public static void main(String[] args) {
		ObserverA oa = new ObserverA();
		ObserverB ob = new ObserverB();
		
		Subject sb = new Subject();
		
		sb.attach(oa);
		sb.attach(ob); 
		
		
		sb.notifyObserver();
	}
	
}
