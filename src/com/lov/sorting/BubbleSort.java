package com.lov.sorting;

import java.util.Arrays;

/**
 * ð������
 * @author P1314023
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {5,7,2,9,4,1,0,5,7};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	/**
	 * ð������
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		
		for (int i = 0 ;i<arr.length-1;i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
	}
	
}
