package com.lov.sorting;

import java.util.Arrays;

/**
 * ��������
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
	 * ��������
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] arr, int start, int end) {
		if (start<end) {
				
	//		�������еĵ�0��������Ϊ��׼��
			int startd = arr[start];
	//		��¼��Ҫ������±�
			int low = start;
			int high = end;
	//		ѭ���ҳ��ȱ�׼���������С����
			while (low<high) {
	//			�ұ������ڱ�׼��
				while (low<high && startd<= arr[high]) {
					high--;
				}
	//			�ұ����滻���
				arr[low] = arr[high];
	//			�����С�ڱ�׼��
				while(low<high&& arr[low]<=startd) {
					low++;
				}
				arr[high] = arr[low];
			}
	//		��׼����ֵ�м�
			arr[low] = startd;
			
			quickSort(arr, 0, low);
			quickSort(arr,low+1,end);
		}
	}
	
}
