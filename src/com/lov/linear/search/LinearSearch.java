package com.lov.linear.search;

/**
 *
 *	���Բ��ң�
 *	������Ԫ�ؽ��б�����ѯ
 *
 */
public class LinearSearch {
	
	public static void main(String[] args) {
//		Ŀ������
		int[] arr = {1,3,4,5,6,7,8};
//		����Ԫ��
		int target = 4;
//		Ԫ���±�
		int index = -1;
//		����
		for(int i = 0;i<arr.length;i++) {
			if (arr[i] == target) {
				index = i+1;
				break;
			}
			
		}
//		���
		System.out.println("index:"+index);
		
	}
}
