package com.lov.sorting;

import java.util.Arrays;

/**
 * 快速排序
 * @author P1314023
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {3,4,6,7,2,7,2,8,0};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 快速排序
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] arr, int start, int end) {
		if (start<end) {
				
	//		把数组中的第0个数字作为标准数
			int startd = arr[start];
	//		记录需要排序的下标
			int low = start;
			int high = end;
	//		循环找出比标准数大的数和小的数
			while (low<high) {
	//			右边数大于标准数
				while (low<high && startd<= arr[high]) {
					high--;
				}
	//			右边数替换左边
				arr[low] = arr[high];
	//			左边数小于标准数
				while(low<high&& arr[low]<=startd) {
					low++;
				}
				arr[high] = arr[low];
			}
	//		标准数赋值中间
			arr[low] = startd;
			
			quickSort(arr, 0, low);
			quickSort(arr,low+1,end);
		}
	}
	
}
