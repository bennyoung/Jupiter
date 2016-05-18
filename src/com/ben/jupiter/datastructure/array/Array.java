/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: BenArray.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Yang Bin
* @date: 25 Apr 2016 10:51:42 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 25 Apr 2016     Yang Bin           v1.0.0               修改原因
*/
package com.ben.jupiter.datastructure.array;

/**
 * @author Yang Bin
 *
 */
public class Array {

	private int size = 0;
	
	private int array[] = null;
	
	private int index = 0;
	
	public Array(int size) {
		this.size = size;
		this.array = new int[size];
		int arr[][] = new int[][]{{1}};
		System.out.println("-------" + arr[0][0]);
	}
	
	public void insert(int i) {
		array[index] = i;
		index++;
	}
	
	public int find(int value) {
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			tmp = array[i];
			if (tmp == value) {
				return tmp;
			}
		}
		return 0;
	}
	
	public boolean delete(int value) {
		
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				sb.append(array[i]);
			} else {
				sb.append(array[i]).append(", ");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Array array = new Array(5);
		array.insert(1);
		array.insert(4);
		array.insert(3);
		array.insert(8);
		array.insert(7);
		
		int i = array.find(4);
		System.out.println("-------" + i);
		System.out.println(array.toString());
	}
	
}
