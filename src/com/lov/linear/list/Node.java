package com.lov.linear.list;

public class Node {

//	数据
	int data;
//	下一个节点
	Node next;
//	constructor
	public Node(int data) {
		this.data = data;
	}
//	append 追加节点
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
//	next 获取下一个节点
	public Node next() {
		
		return next;
	}
//	getData 获取节点数据
	public int getData() {
		return data;
	}
//	isLast 最后节点
	public boolean isLast() {
		return next == null;
	}
//	removeNext 删除下一个节点
	public void removeNext() {
//		取出下下一个节点
		Node nNext = next.next;
//		将next指向该节点
		this.next = nNext;
	}
//	show 输出所有节点
	public void show() {
//		获取当前节点
		Node current = this;
//		循环打印
		while (true) {
			System.out.print(current.data+",");
			if (current.next == null) {
				System.out.println();
				break;
			}
//			指定下一节点
			current = current.next;
		}
		
	}
//	after 在某一节点后插入节点
	public void after(Node node) {
//		获取下个节点
		Node after = this.next;
//		将next指向插入的node
		this.next = node;
//		指向after节点
		node.next = after;
	}
}
