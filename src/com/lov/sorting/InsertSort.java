package com.lov.sorting;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,1,0};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 插入排序
	 * @param arr
	 */
	private static void insertSort(int[] arr) {
//		遍历所有数字
		for (int i = 1; i < arr.length; i++) {
//			当前数字比前一个数字小
			if (arr[i]<arr[i-1]) {
				int tmp = arr[i];
				int j;
//				遍历当前数字前面的数字
				for (j = i-1; j>=0&&tmp < arr[j]; j--) {
//					把前一个数值赋给后一个数
					arr[j+1] = arr[j];
				}
				arr[j+1] = tmp;
			}
		}
		
	}
}
