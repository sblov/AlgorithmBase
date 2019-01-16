package com.lov.sorting;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {3,4,5,7,1,2,0,3,6,8};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 简单选择排序
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
//		遍历所有的数
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
//			把当前遍历数后面所有数依次进行比较
			for (int j = i+1; j < arr.length; j++) {
//				比当前最小数小
				if (arr[j]<arr[minIndex]) {
					minIndex = j;
				}
			}
//			当最小数不是当前遍历的数
			if (i!= minIndex) {
				int tmp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tmp;
			}
		}
	}
	
}
