package com.lov.linear;
/*
 * Recursive �ݹ�
 * 	����˹��ЧӦͼ���൱�����ž����վ���
 */
public class Recursive {
	
	public static void main(String[] args) {
		
		print(10);
	}
	
	public static void print(int n) {
		if (n>=0) {
			System.out.println(n);
			print(n-1);			
		}
	}
	
}
