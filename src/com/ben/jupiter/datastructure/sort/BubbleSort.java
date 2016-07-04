/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: BubbleSort.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 25 Apr 2016 14:28:25 
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
public class BubbleSort {

	public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        BubbleSort.sort(a);
    }
	
	public static void sort(int[] a) {
		System.out.println("before：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        
        System.out.println();
        
        for (int i = 0; i < a.length; i++) {
        	int tmp;
        	for (int j = 0; j < a.length - i - 1; j++) {
        		if (a[j] > a[j + 1]) {
        			tmp = a[j + 1];
        			a[j + 1] = a[j];
        			a[j] = tmp;
        		}
        	}
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
	}
	
}
