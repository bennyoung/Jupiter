/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: IntegetTest.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年6月14日 下午6:31:47 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年6月14日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.test;

/**
 * @author Ben
 *
 */
public class IntegerTest {
	
	public static void main(String[] args) {
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 = Integer.valueOf(59);
		Integer i04 = new Integer(59);
		
		System.out.println(i01 == i02);
		System.out.println(i01 == i03);
		System.out.println(i03 == i04);
		System.out.println(i02 == i04);
	}
}
