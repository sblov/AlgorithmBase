package com.lov.linear.list;

public class DoubleNode {

	DoubleNode pre =this;
	DoubleNode next = this;
	int data;
	public DoubleNode(int data) {
		this.data = data;
	}
	
	public  void after(DoubleNode node) {
//		获取下个节点
		DoubleNode after = this.next;
//		将next指向插入的node
		this.next = node;
//		指向after节点
		node.next = after;
		node.pre = this;
		after.pre = node;
	}
	
	public DoubleNode next() {
		return this.next;
	}
	public DoubleNode pre() {
		return this.pre;
	}
	
	public int getData() {
		return this.data;
	}
	
}
