package com.lov.linear;

public class MyQueue {

	int[] queue ;
//	constructor
	public MyQueue() {
		queue = new int[0];
	}
	
//	add ���
	public void add(int value) {
//		������
		int[] newArr= new int[queue.length+1];
//		��������
		for (int i = 0; i < queue.length; i++) {
			newArr[i] = queue[i];
		}
//		���value
		newArr[queue.length] = value;
//		�滻����
		queue = newArr;
	}
//	poll ����
	public int poll() {
//		ȡ����һ��Ԫ��
		int poll = queue[0];
//		������
		int[] newArr= new int[queue.length-1];
//		��������
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = queue[i+1];
		}

//		�滻����
		queue = newArr;
//		����
		return poll; 
	}
	
//	isEmpty
	public boolean isEmpty() {
		return queue.length == 0;
	}

}
