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
	 * 堆排序
	 * @param arr
	 */
	public static void heapSort(int[] arr) {
//		最后一个叶节点的父节点
		int start = (arr.length-1)/2;
//		调整为大顶堆
		for(int i = start;i>= 0 ;i--) {
			maxHeap(arr, arr.length, i);
		}
//		先把数组第一个与最后一个交换位置，再将前面的部分处理为大顶堆
		for (int i = arr.length-1; i >0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeap(arr, i, 0);
		}
	}
	
	
	/**
	 * 大顶堆
	 * @param arr
	 * @param size
	 * @param index
	 */
	public static void maxHeap(int[] arr,int size,int index) {
		
//		左子节点
		int leftNode = 2*index + 1;
//		右子节点
		int rightNode = 2*index + 2;
//		求最大值
		int max = index;
		if (leftNode<size&&arr[leftNode]>arr[max]) {
			max = leftNode;
		}
		if (rightNode<size&&arr[rightNode]>arr[max]) {
			max = rightNode;
		}
//		交换位置
		if (max!=index) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
//			交换位置后，可能会破坏之前拍好的堆，所以重新调整
			maxHeap(arr, size, max);
		}
		
	}
}
