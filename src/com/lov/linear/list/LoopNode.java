package com.lov.linear.list;

public class LoopNode {
	

//		数据
		int data;
//		下一个节点
		LoopNode next;
//		constructor
		public LoopNode(int data) {
			this.data = data;
		}

//		next 获取下一个节点
		public LoopNode next() {
			
			return next;
		}
//		getData 获取节点数据
		public int getData() {
			return data;
		}

//		removeNext 删除下一个节点
		public void removeNext() {
//			取出下下一个节点
			LoopNode nNext = next.next;
//			将next指向该节点
			this.next = nNext;
		}

//		after 在某一节点后插入节点
		public void after(LoopNode node) {
//			获取下个节点
			LoopNode after = this.next;
//			将next指向插入的node
			this.next = node;
//			指向after节点
			node.next = after;
		}
	}

