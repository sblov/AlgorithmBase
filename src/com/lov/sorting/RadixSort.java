package com.lov.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {23,6,189,45,9,287,56,1,798,34,65,652,5};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void radixSort(int[] arr) {
		int max = Integer.MIN_VALUE;
//		取数组中最大值
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
			}
		}
//		System.out.println(max);
//		计算最大数字位数
		int maxLength = (max+"").length();
//		临时存储数据
		int[][] tmp = new int[10][arr.length];
//		用于记录在temp中存放的数字的数量
		int[] counts = new int[10];
//		根据最大位数决定比较次数
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
//			每个数求余
			for(int j=0;j<arr.length;j++) {
//				计算余数
				int result = arr[j]/n%10;
				tmp[result][counts[result]] = arr[j];
//				记录数量
				counts[result]++;
			}
//			记录取的元素需要存放的位置
			int index = 0;
//			将数字取出
			for(int k=0;k<counts.length;k++) {
//				记录数量的数组中当前余数记录的数量不为0
				if (counts[k]!=0) {
//					循环取出元素
					for(int l=0;l<counts[k];l++) {
						arr[index] = tmp[k][l];
						index++;
					}
//					数量置空
					counts[k] = 0;
				}
			}
		}
			
	}
	
}
