package com.lov.tree;

/*
 * 顺序二叉树
 * 	将数组当成二叉树处理
 */
public class ArrayBinaryTree {
//	data
	int[] data ;
//	constructor
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}
//	重载调用
	public void frontShow() {
		frontShow(0);
	}
	
//	前序遍历
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
