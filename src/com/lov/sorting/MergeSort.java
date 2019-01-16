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
	 * �鲢����
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] arr,int low,int mid,int high) {
//		���ڴ洢�鲢�����ʱ����
		int[] tmp = new int[high-low+1];
//		��¼��һ����������Ҫ�������±�
		int i = low;
//		��¼�ڶ�����������Ҫ�������±�
		int j = mid+1;
//		���ڼ�¼����ʱ�����д�ŵ��±�
		int index = 0;
//		������������ȡ��С�����֣�������ʱ������
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
//		�����������
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
//		��ʱ����ԭ����
		for (int k = 0; k < tmp.length; k++) {
			arr[low+k] = tmp[k]; 
		}
	}
	
}
