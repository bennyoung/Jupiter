/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AboutSystem.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月31日 下午7:33:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月31日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.lang;

/**
 * @author Ben
 *
 */
public class AboutSystem {
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.vm.name"));
		System.out.println(System.getProperty("java.vm.info"));
	}
}
