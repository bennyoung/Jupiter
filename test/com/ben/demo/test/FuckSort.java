package com.ben.demo.test;

import java.util.Arrays;

public class FuckSort {

	public static void main(String[] args) {
		int[] fuck = {9,8,7,6,5,4,3,2,1};
		for (int i = 0; i < fuck.length; i++) {
			for (int k = i + 1; k < fuck.length; k++) {
				fuck[i] = fuck[i] > fuck[k] ? (fuck[i] = fuck[i] ^ fuck[k]) ^ (fuck[k] = fuck[i] ^ fuck[k]) : fuck[i];
			}
		}
		System.out.println(Arrays.toString(fuck));
	}
	
}
