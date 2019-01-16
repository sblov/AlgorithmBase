package com.lov.tree;

/*
 * �����������ڵ�
 */
public class ThreadNode {

//	�ڵ��Ȩ
	int data ;
//	���ӽڵ�
	ThreadNode lNode;
//	���ӽڵ�
	ThreadNode rNode;
//	��ʶָ�����ͣ��ӽڵ��ǰ���ڵ�
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
	
//	ǰ�����
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
	public ThreadNode frontSearch(int value) {
		
		ThreadNode target = null;
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
		ThreadNode parent = this;
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
