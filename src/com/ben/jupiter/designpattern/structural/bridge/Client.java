/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Client.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月26日 上午10:51:46 
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
public class Client {

	public static void main(String[] args) {
		ITV tv = new SonyTV();
		LogicRemoteControl rc = new LogicRemoteControl(tv);
		rc.setChannelKeyBoard(1);
	}
	
}
