/**   
* Copyright: Copyright (c) 2015 Asiainfo
* 
* @ClassName: StringUtils.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 10 Nov 2015 11:45:25 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 10 Nov 2015     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.util;

import java.util.Stack;

/**
 * @author Yang Bin
 *
 */
public class StringUtil {

	public static final char[] c = new char[]{'a', 'e', 'i', 'o', 'u'};
	
	/**
	 * 
	 * @Function: StringUtils.java
	 * @Description: 字符串反转
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Yang Bin
	 * @date: 11 Nov 2015 16:07:15
	 *
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 11 Nov 2015     Yang Bin           v1.0.0               修改原因
	 */
	public static String revert(String s) throws Exception {
		String rtn = null;
		char[] c = s.toCharArray();
		char[] tmp = new char[c.length];
		for (int i = 0; i < c.length; i++) {
			tmp[i] = c[c.length - 1 - i];
		}
		rtn = new String(tmp);
		return rtn;
	}
	
	
	public static String revert2(String s) throws Exception {
		String rtn = null;
		Stack stack = new Stack();
		char[] c = s.toCharArray();
		for (char ch : c) {
			stack.push(ch);
		}
		
//		char[] tmp = new char[s.length()];
//		for (int i = 0; i < s.length(); i++) {
//			tmp[i] = stack.pop();
//		}
		
		return rtn;
	}
	
	
	public String latiPig(String s) throws Exception {
		String rtn = null;
		
		
		
		return rtn;
	}
	
	public int statisticsVowel(String s) throws Exception {
		int num = 0;
		
		return num;
	}
	
	public static void main(String args[]) throws Exception {
		String s = "yangbin";
		System.out.println(s);
		System.out.println(StringUtil.revert(s));
	}
	
}
