/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: StringLengthDescComparator.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月14日 下午3:53:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月14日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ben
 *
 */
public class StringLengthDescComparator implements Comparator {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String)o1;
		String s2 = (String)o2;
		
		int rtn = 0;
		int r1 = s1.length();
		int r2 = s2.length();
		
		if (r1 == r2) {
			rtn = 0;
		} else if (r1 > r2) {
			rtn = -1;
		} else if (r1 < r2) {
			rtn = 1;
		} else {
			rtn = 0;
		}
		
		return rtn;
	}

	public static void main(String[] args) {
		List list = new ArrayList();

	    for (int i = 0; i < 10001; i++) {
	      list.add("str" + i + "str");
	    }

	    String[] a = (String[])list.toArray(new String[0]);
	    Arrays.sort(a,new StringLengthDescComparator());
	    
//	    for (int i = 0; i < a.length; i++) {
//	    	System.out.println(a[i]);
//	    }
	    
		long start = System.currentTimeMillis();
		for (int j = 0; j < 10000; j++) {
			for (int i = 0; i < a.length; i++) {
				if ("str0".indexOf(a[i]) != -1) {
					// 设置数据源
					break;
				}
			}
		}
		System.out.println("Time cost:" + (System.currentTimeMillis() - start)
				+ ":ms");
	}
	

}
