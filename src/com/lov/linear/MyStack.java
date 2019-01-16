package com.lov.linear;
/*
 * ջ
 */
public class MyStack {

	int[] stack;
//	constructor
	public MyStack() {
		stack = new int[0];
	}
//	push ѹջ
	public void push(int value) {
//		������
		int[] newArr = new int[stack.length+1];
//		ԭ�������ݸ��Ƶ�������
		for (int i = 0; i < stack.length; i++) {
			newArr[i] = stack[i];
		}
//		�����Ԫ��
		newArr[stack.length] = value;
//		��������������
		stack = newArr;
	}
	
//	pop ��ջ
	public int pop() {
//		Ϊ���ж�
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
//		ȡ�����һ��Ԫ��
		int pop = stack[stack.length-1];
//		������
		int[] newArr = new int[stack.length-1];
//		ԭ�������ݸ��Ƶ�������	
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = stack[i];
		}
//		��������������
		stack = newArr;
//		pop����
		return pop;
	}
//	peek �鿴ջ��Ԫ��
	public int peek() {
//		Ϊ���ж�
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
