package com.lov.tree;

/*
 * 线索二叉树节点
 */
public class ThreadNode {

//	节点的权
	int data ;
//	左子节点
	ThreadNode lNode;
//	右子节点
	ThreadNode rNode;
//	标识指针类型：子节点或前驱节点
	int lType;
	int rType;
	
//	constructor
	public ThreadNode(int data) {
		this.data = data;
	}
//	setter && getter
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ThreadNode getlNode() {
		return lNode;
	}
	public void setlNode(ThreadNode lNode) {
		this.lNode = lNode;
	}
	public ThreadNode getrNode() {
		return rNode;
	}
	public void setrNode(ThreadNode rNode) {
		this.rNode = rNode;
	}
	
//	前序遍历
	public void frontShow() {
		
		System.out.print(data+",");
		if (lNode != null && lType != 1) {
//			System.out.println(lNode.getData());
			lNode.frontShow();
		}
		if (rNode != null && rType != 1) {
//			System.out.println(rNode.getData());
			rNode.frontShow();
		}
		
	}
//	中序遍历
	public void midShow() {
		if (lNode != null) {

			lNode.midShow();
		}
		
		System.out.print(data+",");
		
		if (rNode != null) {

			rNode.midShow();
		}
	}
//	后序遍历
	public void afterShow() {
		
		if (lNode != null) {

			lNode.afterShow();
		}
		
		
		if (rNode != null) {

			rNode.afterShow();
		}
		System.out.print(data+",");
	}

//	前序查找
	public ThreadNode frontSearch(int value) {
		
		ThreadNode target = null;
//		当前为查找，直接返回
		if(this.data == value) {
			return this;
		}else {
//			左节点
			if (lNode != null) {
				target = lNode.frontSearch(value);
			}
			if (target != null) {
				return target;
			}
//			右节点
			if (rNode != null) {
				target = rNode.frontSearch(value);
			}
		}

		return target;
		
	}
//	删除子节点
	public void delete(int value) {
		ThreadNode parent = this;
		if (parent.lNode!=null&&parent.lNode.data == value) {
			parent.lNode = null;
			return;
		}
		if (parent.rNode!=null&&parent.rNode.data == value) {
			parent.rNode = null;
			return;
		}
//		左节点递归查找删除
		parent = lNode;
		if (parent != null) {
			parent.delete(value);
		}
//		右节点
		parent = rNode;
		if (parent != null) {
			parent.delete(value);
		}
		
	}
	
}
