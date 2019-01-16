package com.lov.sorting;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {3,5,2,7,8,1,2,0,4,7,4,3,8};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 希尔排序
	 * @param arr
	 */
	private static void shellSort(int[] arr) {
//		遍历所有的步长
		for (int d=arr.length/2; d>0; d/=2) {
//			遍历元素
			for (int i = d; i < arr.length; i++) {
//				遍历本组中所有元素
				for(int j =i-d;j>=0;j-=d) {
					if (arr[j]>arr[j+d]) {
						int tmp = arr[j];
						arr[j] = arr[j+d];
						arr[j+d] = tmp;
					}
				}
			}
		}
		
	}
}
