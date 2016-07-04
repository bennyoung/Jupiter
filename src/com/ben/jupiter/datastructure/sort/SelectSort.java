/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: SelectSort.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 25 Apr 2016 18:32:47 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 25 Apr 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.datastructure.sort;

/**
 * @author Yang Bin
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		sort(a);
		
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}
	
	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int n = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					n = j;
				}
			}
			a[n] = a[i];
			a[i] = min;
		}
	}
	
}
