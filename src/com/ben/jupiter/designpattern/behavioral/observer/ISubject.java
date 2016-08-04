/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ISubject.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月28日 上午11:17:12 
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
public interface ISubject {
	
	public void attach(IObserver observer);
	
	public void detach(IObserver observer);

	public void notifyObserver();
	
}
