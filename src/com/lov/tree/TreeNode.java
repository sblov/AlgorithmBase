package com.lov.tree;
/*
 * ���ڵ�
 */
public class TreeNode {
	
//	�ڵ��Ȩ
	int data ;
//	���ӽڵ�
	TreeNode lNode;
//	���ӽڵ�
	TreeNode rNode;
//	constructor
	public TreeNode(int data) {
		this.data = data;
	}
//	setter && getter
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getlNode() {
		return lNode;
	}
	public void setlNode(TreeNode lNode) {
		this.lNode = lNode;
	}
	public TreeNode getrNode() {
		return rNode;
	}
	public void setrNode(TreeNode rNode) {
		this.rNode = rNode;
	}
	
//	ǰ�����
	public void frontShow() {
		
		System.out.print(data+",");
		if (lNode != null) {
//			System.out.println(lNode.getData());
			lNode.frontShow();
		}
		if (rNode != null) {
//			System.out.println(rNode.getData());
			rNode.frontShow();
		}
		
	}
//	�������
	public void midShow() {
		if (lNode != null) {

			lNode.midShow();
		}
		
		System.out.print(data+",");
		
		if (rNode != null) {

			rNode.midShow();
		}
	}
//	�������
	public void afterShow() {
		
		if (lNode != null) {

			lNode.afterShow();
		}
		
		
		if (rNode != null) {

			rNode.afterShow();
		}
		System.out.print(data+",");
	}

//	ǰ�����
	public TreeNode frontSearch(int value) {
		
		TreeNode target = null;
//		��ǰΪ���ң�ֱ�ӷ���
		if(this.data == value) {
			return this;
		}else {
//			��ڵ�
			if (lNode != null) {
				target = lNode.frontSearch(value);
			}
			if (target != null) {
				return target;
			}
//			�ҽڵ�
			if (rNode != null) {
				target = rNode.frontSearch(value);
			}
		}

		return target;
		
	}
//	ɾ���ӽڵ�
	public void delete(int value) {
		TreeNode parent = this;
		if (parent.lNode!=null&&parent.lNode.data == value) {
			parent.lNode = null;
			return;
		}
		if (parent.rNode!=null&&parent.rNode.data == value) {
			parent.rNode = null;
			return;
		}
//		��ڵ�ݹ����ɾ��
		parent = lNode;
		if (parent != null) {
			parent.delete(value);
		}
//		�ҽڵ�
		parent = rNode;
		if (parent != null) {
			parent.delete(value);
		}
		
	}
	
	
	
	
}
