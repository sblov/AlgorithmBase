package com.lov.linear;
/*
 * ��ŵ��
 */
public class Hanoi {

	public static void main(String[] args) {
		
		hanoi(5, 'a', 'b', 'c');
	}
	
	/**
	 * @param n	��ǰ��Ҫ�ƶ���Ԫ��
	 * @param from	��ʼλ��
	 * @param in	�м��λ��
	 * @param to	����λ��
	 */
//	���ں�ŵ�����ԣ�����Ҫ�ƶ�����Ԫ�أ����ն���׷�ݵ��ƶ�һ�����ƶ�����������ֻ��Ҫ�����������ƶ�����
	public static void hanoi(int n,char from,char in,char to) {
//		���ƶ���Ϊ��һ��Ԫ��ʱ
		if(n==1) {
			System.out.println("1:from "+from+" to "+to);
		}else {
//			�ƶ���n��Ԫ��ʱ�����Ƶڶ���Ԫ�����εݹ�
			hanoi(n-1, from, to, in);
			System.out.println(n+":from "+from+" to "+to);
			hanoi(n-1, in,from, to);
		}
	}
}
