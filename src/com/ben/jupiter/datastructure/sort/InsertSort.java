/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: InsertSort.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 26 Apr 2016 19:58:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 26 Apr 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.datastructure.sort;

/**
 * @author Yang Bin
 *
 */
public class InsertSort {

	public static void main(String[] args) {
        int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
        InsertSort.sort2(a);
    }
	
	public static void sort1(int[] a) {
		System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //直接插入排序
        for (int i = 1; i < a.length; i++) {
            //待插入元素
            int temp = a[i];
            int j;
            /*for (j = i-1; j>=0 && a[j]>temp; j--) {
                //将大于temp的往后移动一位
                a[j+1] = a[j];
            }*/
            for (j = i-1; j>=0; j--) {
                //将大于temp的往后移动一位
                if(a[j]>temp){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = temp;
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
	}
	
	public static void sort2(int[] a) {
		System.out.println("before:");
		for (int i = 0; i < a.length -1; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (a[j] > tmp) {
					a[j+1] = a[j];
				} else {
					break;
				}
			}
			System.out.println("j = " + j);
			a[j + 1] = tmp;
		}
		System.out.println("after:");
		for (int i = 0; i < a.length -1; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
