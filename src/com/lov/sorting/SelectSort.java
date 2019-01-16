package com.lov.sorting;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {3,4,5,7,1,2,0,3,6,8};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * ��ѡ������
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
//		�������е���
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
//			�ѵ�ǰ�������������������ν��бȽ�
			for (int j = i+1; j < arr.length; j++) {
//				�ȵ�ǰ��С��С
				if (arr[j]<arr[minIndex]) {
					minIndex = j;
				}
			}
//			����С�����ǵ�ǰ��������
			if (i!= minIndex) {
				int tmp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tmp;
			}
		}
	}
	
}
