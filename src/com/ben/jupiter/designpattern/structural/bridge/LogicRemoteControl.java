/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: LogicRemoteControl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月26日 上午10:44:40 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月26日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.designpattern.structural.bridge;

/**
 * @author Ben
 *
 */
public class LogicRemoteControl extends AbstractRemoteControl {

	/**
	 * @param tv
	 */
	public LogicRemoteControl(ITV tv) {
		super(tv);
	}
	
	public void setChannelKeyBoard(int i) {
		setChannel(i);
		System.out.println("use LogicRemoteControl.");
	}

}
