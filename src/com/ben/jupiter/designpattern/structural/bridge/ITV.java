/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: ITV.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月21日 下午5:09:39 
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
public interface ITV {

	public void turnOff();
	
	public void turnOn();
	
	public void switchChannel(int channelNum);
	
}
