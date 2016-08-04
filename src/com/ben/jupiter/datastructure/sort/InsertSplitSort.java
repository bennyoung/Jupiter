/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: InsertSplitSort.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年8月3日 下午3:43:49 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年8月3日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datastructure.sort;

import java.util.Arrays;

/**
 * @author Ben
 *
 */
public class InsertSplitSort {
	
	public static void main(String[] args) {
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
        InsertSplitSort.insertSplitSort(a);
    }
	
	public static int[] insertSplitSort(int[] sz) {
		int[] data = sz;
		System.out.println("before:" + Arrays.toString(data));
		long beginTime = System.currentTimeMillis();
		
		for (int i = 1; i < data.length; i++) {
			int tmp = data[i];
			int min = 0;
			int big = i - 1;
			while (big >= min) {
				int mid = (min + big) / 2;
				if (tmp > data[mid]) {
					min = mid + 1;
				} else {
					big = mid - 1;
				}
			}
			for (int j = i; j > min; j--) {
				data[j] = data[j - 1];
			}
			data[big + 1] = tmp;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("折半插入[" + (endTime - beginTime) + "]\t\t");
		
		System.out.println("after:" + Arrays.toString(data));
		return data;
	}
}
