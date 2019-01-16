package com.lov.linear;

import java.util.Arrays;


/**
 * @author P1314023
 *	����ʵ��
 *
 */
public class MyArray{
	private int length;
	private int[] array;
	private int flag = 0;
	
	//constructor
	public MyArray(int length) {
		this.length = 0;
		array = new int[length];
//		System.out.println(Arrays.toString(array));
	}
	
//	��ȡ����Ԫ�ظ���
	public int size() {
		return length;
	}
//	���Ԫ��
	public void add(int value) {
		
		if (length < array.length) {
			array[length++] = value;
		}else {
			flag = 0;
			int[] tempArray = new int[array.length+1];
//			System.out.println(tempArray.length+"--");
			Arrays.stream(array).forEach(val->{
//				System.out.println(flag);
				tempArray[flag++] = val;
				
			});
			
			length++;
			tempArray[flag] = value;
			array = tempArray;
		}
	}
	
//	�Ƴ�Ԫ��
	public String remove(int index) {
		
		for(int i=index-1;i<array.length;i++) {
			if (i == array.length-1) {
				int temp = array[i];
				array[i] = 0;
				length--;
				return "index:"+index+"-value:"+temp;
			}
			
			array[i] = array[i+1];
		}
		return "";
		
	}
//	��ӡ����Ԫ��
	public void show() {
		flag = 0;
		 Arrays.stream(array).forEach(val->{
			if (flag >= length) {
				
			}else {
				flag++;
				System.out.print(val+",");
			}
			});
		 System.out.println();
		
	}
//	����һ��Ԫ��
	public String insert(int index,int value) {
		flag =0;
		
		int[] tempArray = new int[this.length+1];
		System.out.println(length);
		Arrays.stream(tempArray).forEach(val->{
			
			if (flag+1 == index) {
				tempArray[flag] = value;
			}else if (flag+1 > index) {
//				System.err.println(flag);
				tempArray[flag] = array[flag-1];
			}else {
				tempArray[flag] = array[flag]; 				
			}
			flag++;
			
		});
		
		length++;
		array = tempArray;
		
		
		return "success";
	}
	
	
}