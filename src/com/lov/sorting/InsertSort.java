package com.lov.sorting;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,1,0};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * ��������
	 * @param arr
	 */
	private static void insertSort(int[] arr) {
//		������������
		for (int i = 1; i < arr.length; i++) {
//			��ǰ���ֱ�ǰһ������С
			if (arr[i]<arr[i-1]) {
				int tmp = arr[i];
				int j;
//				������ǰ����ǰ�������
				for (j = i-1; j>=0&&tmp < arr[j]; j--) {
//					��ǰһ����ֵ������һ����
					arr[j+1] = arr[j];
				}
				arr[j+1] = tmp;
			}
		}
		
	}
}
