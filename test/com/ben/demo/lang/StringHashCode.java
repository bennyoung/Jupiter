/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: StringHashCode.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月12日 上午10:53:48 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月12日     Ben           v1.0.0               修改原因
*/
package com.ben.demo.lang;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ben
 *
 */
public class StringHashCode {
	
	private final int s = 0;

	public static void main(String[] args) {
		String s = "yangbin";
		char[] c = {'y', 'a', 'n', 'g', 'b', 'i', 'n'};
		String s1 = new String(c);
		
		Map map = new HashMap(1000);
		System.out.println(map.size());
		
		int capacity = 1;
		
		System.out.println(s.hashCode());
		
		System.out.println(StringHashCode.hashCode1(s1, c));
		
		System.out.println(Integer.toBinaryString(16));
		
		System.out.println(capacity <<= 1);
		
//		System.out.println(0 + c[0]);
		System.out.println(Thread.currentThread());
	}
	
	public static int hashCode1(String s1, char[] c) {
		int h = 0;
		int len = s1.length();
		if (h == 0 && len > 0) {
			int off = 0;
			char val[] = c;
			for (int i = 0; i < len; i++) {
                h = 31*h + val[off++];
                System.out.println(h);
            }
		}
		return h;
	}
	
}
