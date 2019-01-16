package com.lov.tree;
/*
 * 树节点
 */
public class TreeNode {
	
//	节点的权
	int data ;
//	左子节点
	TreeNode lNode;
//	右子节点
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
	
//	前序遍历
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
	public TreeNode frontSearch(int value) {
		
		TreeNode target = null;
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
		TreeNode parent = this;
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
