/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: QuickSort.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月4日 下午2:24:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月4日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datastructure.sort;

/**
 * @author Ben
 *
 */
public class QuickSort {

	public static void main(String args[]) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		quick(a);
		
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}
	
	public static void quick(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	public static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int mid = getMiddle(a, low, high);
			quickSort(a, 0, mid - 1);
			quickSort(a, mid + 1, high);
		}
	}
	
	public static int getMiddle(int[] a, int low, int high) {
		int temp = a[low];
		while (low < high) {
			 //找到比基准元素小的元素位置
            while(low<high && a[high]>=temp){
                high--;
            }
            a[low] = a[high]; 
            while(low<high && a[low]<=temp){
                low++;
            }
            a[high] = a[low];
		}
		a[low] = temp;
		return low;
	}
	
}
