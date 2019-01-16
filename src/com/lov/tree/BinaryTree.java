package com.lov.tree;
/*
 * ������
 */
public class BinaryTree {
//	root
	TreeNode root;
//	constructor
	public BinaryTree(TreeNode root) {
		this.root = root;
	}
//	root getter
	public TreeNode getRoot() {
		return root;
	}
//	root setter
	public void setRoot(TreeNode root) {
		this.root = root;
	}
//	����
	public void frontShow() {
		root.frontShow();
		
	}
	public void midShow() {
		root.midShow();
	}
	public void afterShow() {
		root.afterShow();
	}
//	����
	public TreeNode frontSearch(int i) {
		
		return root.frontSearch(i);
	}
//	ɾ��
	public void delete(int value) {
		
		if (root.data == value) {
			root = null;
		}else {
			root.delete(value);
		}
		
	}
	
	

	
}
