package com.lov.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1,3,5,2,4,6,8,10};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void mergeSort(int[] arr,int low,int high) {
		int mid = (low+high)/2;
		if (low<high ) {
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	
	/**
	 * 归并排序
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] arr,int low,int mid,int high) {
//		用于存储归并后的临时数组
		int[] tmp = new int[high-low+1];
//		记录第一个数组中需要遍历的下标
		int i = low;
//		记录第二个数组中需要遍历的下标
		int j = mid+1;
//		用于记录在临时数组中存放的下标
		int index = 0;
//		遍历两个数组取出小的数字，放入临时数组中
		while (i<=mid&&j<=high) {
			if (arr[i]<=arr[j]) {
				tmp[index] = arr[i];
				i++;
			}else {
				tmp[index] = arr[j];
				j++;
			}
			index++;
		}
//		处理多余数据
		while (j<=high) {
			tmp[index] = arr[j];
			j++;
			index++;
		}
		while (i<=mid) {
			tmp[index] = arr[i];
			i++;
			index++;
		}
//		临时存入原数组
		for (int k = 0; k < tmp.length; k++) {
			arr[low+k] = tmp[k]; 
		}
	}
	
}
