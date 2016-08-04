/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Subject.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月28日 上午11:20:29 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月28日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ben
 *
 */
public class Subject implements ISubject {

	private List<IObserver> observerList = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.observer.ISubject#attach()
	 */
	@Override
	public void attach(IObserver observer) {
		observerList.add(observer);
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.observer.ISubject#detach()
	 */
	@Override
	public void detach(IObserver observer) {
		observerList.remove(observer);
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.behavioral.observer.ISubject#notifyObserver()
	 */
	@Override
	public void notifyObserver() {
		for (IObserver ob : observerList) {
			ob.update();
		}
		
	}

}
