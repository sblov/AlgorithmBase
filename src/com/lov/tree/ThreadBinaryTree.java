package com.lov.tree;

import org.omg.CORBA.DynAny;

/*
 * ������������
 */
public class ThreadBinaryTree {

//	root
	ThreadNode root;
//	pre ��һ���ڵ�
	ThreadNode pre;
//	constructor
	public ThreadBinaryTree(ThreadNode root) {
		this.root = root;
	}
	public void threadNodes() {
		threadNodes(root);
	}
//	����������������
	public void threadIterate() {
//		��ǰnode
		ThreadNode node = root;

		while (node != null) {
//			���ӽڵ�(��ǰ���ڵ�ʱ)Ϊ��ǰ�ڵ�
			while (node.lType == 0 ) {
				node = node.lNode;
				System.out.println(node.lType);
			}
//			�����ǰ�ڵ�
			System.out.println(node.data);
//			���ӽڵ�(�к�̽ڵ�ʱ)Ϊ��ǰ�ڵ�
			while (node.rType == 1) {
				node = node.rNode;
				System.out.println(node.data);
			}
//			���ָ��ǰ�ڵ�����ӽڵ�,�滻�����Ľڵ�
			node = node.rNode;
		}
	}
//	����������������
	public void threadNodes(ThreadNode node) {
		
//		�жϵ�ǰ�ڵ㲻Ϊ��
		if (node == null) {
			return;
		}
//		���ӽڵ�������
		threadNodes(node.lNode);
//		�����ӽڵ�Ϊ�գ�ָ����һ���ڵ�
		if (node.lNode == null) {
			node.lNode = pre;
			node.lType = 1;
		}
//		����һ���ڵ㲻Ϊ���������ӽڵ�Ϊ�գ��������ӽڵ�ָ��ǰ�ڵ�
		if (pre != null && pre.rNode == null) {
			pre.rNode = node;
			pre.rType = 1;
//			��󽫵�ǰ�ڵ���Ϊ���������Ľڵ㷵��
			pre = node;
		}
//		�����ӽڵ�������
		threadNodes(node.rNode);
//		�����ӽڵ�Ϊ��
		if (node.rNode == null) {
//			���ýڵ���Ϊ��������󷵻ؽڵ�
			pre = node;                                    
		}
	}
	
	
//	root getter
	public ThreadNode getRoot() {
		return root;
	}
//	root setter
	public void setRoot(ThreadNode root) {
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
	public ThreadNode frontSearch(int i) {
		
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
