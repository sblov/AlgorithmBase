package com.lov.sorting;

import java.util.Arrays;

/**

 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr =  {9,6,8,7,0,1,10,4,2};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * ������
	 * @param arr
	 */
	public static void heapSort(int[] arr) {
//		���һ��Ҷ�ڵ�ĸ��ڵ�
		int start = (arr.length-1)/2;
//		����Ϊ�󶥶�
		for(int i = start;i>= 0 ;i--) {
			maxHeap(arr, arr.length, i);
		}
//		�Ȱ������һ�������һ������λ�ã��ٽ�ǰ��Ĳ��ִ���Ϊ�󶥶�
		for (int i = arr.length-1; i >0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeap(arr, i, 0);
		}
	}
	
	
	/**
	 * �󶥶�
	 * @param arr
	 * @param size
	 * @param index
	 */
	public static void maxHeap(int[] arr,int size,int index) {
		
//		���ӽڵ�
		int leftNode = 2*index + 1;
//		���ӽڵ�
		int rightNode = 2*index + 2;
//		�����ֵ
		int max = index;
		if (leftNode<size&&arr[leftNode]>arr[max]) {
			max = leftNode;
		}
		if (rightNode<size&&arr[rightNode]>arr[max]) {
			max = rightNode;
		}
//		����λ��
		if (max!=index) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
//			����λ�ú󣬿��ܻ��ƻ�֮ǰ�ĺõĶѣ��������µ���
			maxHeap(arr, size, max);
		}
		
	}
}
