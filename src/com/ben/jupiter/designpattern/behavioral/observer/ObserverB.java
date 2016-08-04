/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ObserverB.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月28日 下午2:55:48 
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
public class ObserverB implements IObserver {

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.observer.IObserver#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("ObserverB");
	}

}
