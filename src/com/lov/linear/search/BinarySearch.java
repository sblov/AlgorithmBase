package com.lov.linear.search;

/*
 * ���ַ�����
 * ���ź�������ݣ�ȡ�м�ֵ��������ݶԱȣ�ѡ��һ�ߣ��ٽ�����ͬ��ʽ�Ƚ�
 */
public class BinarySearch {

	public static void main(String[] args) {
//		Ŀ������
		int[] arr = {1,2,3,4,5,6,7,8,9};
//		Ŀ��Ԫ��
		int target = 8;
//		���ҿ�ʼλ��
		int begin = 0;
//		���ҽ���λ��
		int end = arr.length-1;
//		�����м�λ��
		int mid = (begin+end/2);
//		Ŀ��λ��
		int index = -1;
//		ѭ������
		while (true) {
//			�ж�
			if (arr[mid] == target) {
				index = mid+1;
				break;
			}else {
//				Ŀ��Ԫ��С���м�λ��
				if (arr[mid] > target) {
//					endΪ�м�λ��ǰһ��λ
					end = mid-1;
				}else {
//					Ŀ��Ԫ�ش����м�λ��
//					beginΪ�м�λ�ú�һ��λ
					begin = mid+1;
				}
//				���µ��м�ֵ
				mid = (begin+end)/2;
			}
			
		}
//		���
		System.out.println("index:"+index);
	}
	
}
