/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: Test.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 4 May 2016 11:00:03 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 4 May 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.demo.test;


/**
 * @author Yang Bin
 *
 */
public class Test {

//	private static Instrumentation instr;
	
	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(s.indexOf("o", 7));
		
		int i = 10;
		System.out.println(i >> 2);
		System.out.println(Integer.toBinaryString(i));
		
		char c = '杨';
		
		System.out.println(c);
		System.out.println((int)Character.MAX_VALUE);
		
		String ss = "s";
		System.out.println(ss);
		
		System.gc();
	}
	
}
