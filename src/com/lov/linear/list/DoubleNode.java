package com.lov.linear.list;

public class DoubleNode {

	DoubleNode pre =this;
	DoubleNode next = this;
	int data;
	public DoubleNode(int data) {
		this.data = data;
	}
	
	public  void after(DoubleNode node) {
//		��ȡ�¸��ڵ�
		DoubleNode after = this.next;
//		��nextָ������node
		this.next = node;
//		ָ��after�ڵ�
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
