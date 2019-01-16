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
//		ȡ���������ֵ
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
			}
		}
//		System.out.println(max);
//		�����������λ��
		int maxLength = (max+"").length();
//		��ʱ�洢����
		int[][] tmp = new int[10][arr.length];
//		���ڼ�¼��temp�д�ŵ����ֵ�����
		int[] counts = new int[10];
//		�������λ�������Ƚϴ���
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
//			ÿ��������
			for(int j=0;j<arr.length;j++) {
//				��������
				int result = arr[j]/n%10;
				tmp[result][counts[result]] = arr[j];
//				��¼����
				counts[result]++;
			}
//			��¼ȡ��Ԫ����Ҫ��ŵ�λ��
			int index = 0;
//			������ȡ��
			for(int k=0;k<counts.length;k++) {
//				��¼�����������е�ǰ������¼��������Ϊ0
				if (counts[k]!=0) {
//					ѭ��ȡ��Ԫ��
					for(int l=0;l<counts[k];l++) {
						arr[index] = tmp[k][l];
						index++;
					}
//					�����ÿ�
					counts[k] = 0;
				}
			}
		}
			
	}
	
}
