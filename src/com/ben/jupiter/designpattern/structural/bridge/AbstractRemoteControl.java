/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AbstractRemoteControl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月21日 下午5:12:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月21日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.structural.bridge;

/**
 * @author Ben
 *
 */
public abstract class AbstractRemoteControl {

	private ITV tv;
	
	public AbstractRemoteControl(ITV tv) {
		this.tv = tv;
	}
	
	public void turnOff() {
		tv.turnOff();
	}
	
	public void turnOn() {
		tv.turnOn();
	}
	
	public void setChannel(int i) {
		tv.switchChannel(i);
	};
	
}
