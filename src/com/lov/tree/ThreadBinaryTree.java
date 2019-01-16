package com.lov.tree;

import org.omg.CORBA.DynAny;

/*
 * 线索化二叉树
 */
public class ThreadBinaryTree {

//	root
	ThreadNode root;
//	pre 上一个节点
	ThreadNode pre;
//	constructor
	public ThreadBinaryTree(ThreadNode root) {
		this.root = root;
	}
	public void threadNodes() {
		threadNodes(root);
	}
//	遍历线索化二叉树
	public void threadIterate() {
//		当前node
		ThreadNode node = root;

		while (node != null) {
//			左子节点(无前驱节点时)为当前节点
			while (node.lType == 0 ) {
				node = node.lNode;
				System.out.println(node.lType);
			}
//			输出当前节点
			System.out.println(node.data);
//			右子节点(有后继节点时)为当前节点
			while (node.rType == 1) {
				node = node.rNode;
				System.out.println(node.data);
			}
//			最后都指向当前节点的右子节点,替换遍历的节点
			node = node.rNode;
		}
	}
//	中序线索化二叉树
	public void threadNodes(ThreadNode node) {
		
//		判断当前节点不为空
		if (node == null) {
			return;
		}
//		左子节点线索化
		threadNodes(node.lNode);
//		当左子节点为空，指向上一个节点
		if (node.lNode == null) {
			node.lNode = pre;
			node.lType = 1;
		}
//		若上一个节点不为空且其右子节点为空，将其右子节点指向当前节点
		if (pre != null && pre.rNode == null) {
			pre.rNode = node;
			pre.rType = 1;
//			最后将当前节点作为该子树最后的节点返回
			pre = node;
		}
//		对右子节点线索化
		threadNodes(node.rNode);
//		当右子节点为空
		if (node.rNode == null) {
//			将该节点作为该子树最后返回节点
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
//	遍历
	public void frontShow() {
		root.frontShow();
		
	}
	public void midShow() {
		root.midShow();
	}
	public void afterShow() {
		root.afterShow();
	}
//	查找
	public ThreadNode frontSearch(int i) {
		
		return root.frontSearch(i);
	}
//	删除
	public void delete(int value) {
		
		if (root.data == value) {
			root = null;
		}else {
			root.delete(value);
		}
		
	}
	
	
}
