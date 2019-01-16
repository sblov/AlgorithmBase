package com.lov.linear;

public class MyQueue {

	int[] queue ;
//	constructor
	public MyQueue() {
		queue = new int[0];
	}
	
//	add 入队
	public void add(int value) {
//		新数组
		int[] newArr= new int[queue.length+1];
//		复制数组
		for (int i = 0; i < queue.length; i++) {
			newArr[i] = queue[i];
		}
//		添加value
		newArr[queue.length] = value;
//		替换数组
		queue = newArr;
	}
//	poll 出队
	public int poll() {
//		取出第一个元素
		int poll = queue[0];
//		新数组
		int[] newArr= new int[queue.length-1];
//		复制数组
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = queue[i+1];
		}

//		替换数组
		queue = newArr;
//		返回
		return poll; 
	}
	
//	isEmpty
	public boolean isEmpty() {
		return queue.length == 0;
	}

}
