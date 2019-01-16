package com.lov.linear;
/*
 * 栈
 */
public class MyStack {

	int[] stack;
//	constructor
	public MyStack() {
		stack = new int[0];
	}
//	push 压栈
	public void push(int value) {
//		新数组
		int[] newArr = new int[stack.length+1];
//		原数组数据复制到新数组
		for (int i = 0; i < stack.length; i++) {
			newArr[i] = stack[i];
		}
//		添加新元素
		newArr[stack.length] = value;
//		新数组代替旧数组
		stack = newArr;
	}
	
//	pop 出栈
	public int pop() {
//		为空判断
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
//		取出最后一个元素
		int pop = stack[stack.length-1];
//		新数组
		int[] newArr = new int[stack.length-1];
//		原数组数据复制到新数组	
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = stack[i];
		}
//		新数组代替旧数组
		stack = newArr;
//		pop返回
		return pop;
	}
//	peek 查看栈顶元素
	public int peek() {
//		为空判断
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return stack[stack.length-1];
	}
//	isEmpty
	public boolean isEmpty() {
		return stack.length == 0;
	}
}
