package com.lov.linear.list;

public class Node {

//	����
	int data;
//	��һ���ڵ�
	Node next;
//	constructor
	public Node(int data) {
		this.data = data;
	}
//	append ׷�ӽڵ�
	public Node append(Node node) {
//		next = node;
		Node current = this;
		while (true) {
			Node nextNode = current.next;
			if(nextNode == null ) {
				break;
			}
			current = nextNode;
		}
		current.next = node;
		return next;
	}
//	next ��ȡ��һ���ڵ�
	public Node next() {
		
		return next;
	}
//	getData ��ȡ�ڵ�����
	public int getData() {
		return data;
	}
//	isLast ���ڵ�
	public boolean isLast() {
		return next == null;
	}
//	removeNext ɾ����һ���ڵ�
	public void removeNext() {
//		ȡ������һ���ڵ�
		Node nNext = next.next;
//		��nextָ��ýڵ�
		this.next = nNext;
	}
//	show ������нڵ�
	public void show() {
//		��ȡ��ǰ�ڵ�
		Node current = this;
//		ѭ����ӡ
		while (true) {
			System.out.print(current.data+",");
			if (current.next == null) {
				System.out.println();
				break;
			}
//			ָ����һ�ڵ�
			current = current.next;
		}
		
	}
//	after ��ĳһ�ڵ�����ڵ�
	public void after(Node node) {
//		��ȡ�¸��ڵ�
		Node after = this.next;
//		��nextָ������node
		this.next = node;
//		ָ��after�ڵ�
		node.next = after;
	}
}
