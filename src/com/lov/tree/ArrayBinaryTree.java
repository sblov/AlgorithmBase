package com.lov.tree;

/*
 * ˳�������
 * 	�����鵱�ɶ���������
 */
public class ArrayBinaryTree {
//	data
	int[] data ;
//	constructor
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}
//	���ص���
	public void frontShow() {
		frontShow(0);
	}
	
//	ǰ�����
	public void frontShow(int index) {
//		null?
		if (data == null || data.length == 0) {
			return;
		}
//		print
		System.out.println(data[index]);
		if(2*index+1 < data.length) {
			frontShow(2*index+1);
		}
		if(2*index+2 < data.length) {
			frontShow(2*index+2);
		}
	}
	
}
