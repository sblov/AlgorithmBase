package com.lov.linear.list;

public class LoopNode {
	

//		����
		int data;
//		��һ���ڵ�
		LoopNode next;
//		constructor
		public LoopNode(int data) {
			this.data = data;
		}

//		next ��ȡ��һ���ڵ�
		public LoopNode next() {
			
			return next;
		}
//		getData ��ȡ�ڵ�����
		public int getData() {
			return data;
		}

//		removeNext ɾ����һ���ڵ�
		public void removeNext() {
//			ȡ������һ���ڵ�
			LoopNode nNext = next.next;
//			��nextָ��ýڵ�
			this.next = nNext;
		}

//		after ��ĳһ�ڵ�����ڵ�
		public void after(LoopNode node) {
//			��ȡ�¸��ڵ�
			LoopNode after = this.next;
//			��nextָ������node
			this.next = node;
//			ָ��after�ڵ�
			node.next = after;
		}
	}

