/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: SonyTV.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月26日 上午10:40:56 
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
public class SonyTV implements ITV {

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.structural.bridge.ITV#turnOff()
	 */
	@Override
	public void turnOff() {
		System.out.println("SonyTV turn off.");
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.structural.bridge.ITV#turnOn()
	 */
	@Override
	public void turnOn() {
		System.out.println("SonyTV turn on.");
	}

	/* (non-Javadoc)
	 * @see com.ben.jupiter.designpattern.structural.bridge.ITV#switchChannel(int)
	 */
	@Override
	public void switchChannel(int channelNum) {
		System.out.println("SonyTV switchChannel " + channelNum + ".");
	}

}
