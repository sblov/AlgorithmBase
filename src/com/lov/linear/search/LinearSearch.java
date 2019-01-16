package com.lov.linear.search;

/**
 *
 *	线性查找：
 *	对所有元素进行遍历查询
 *
 */
public class LinearSearch {
	
	public static void main(String[] args) {
//		目标数据
		int[] arr = {1,3,4,5,6,7,8};
//		查找元素
		int target = 4;
//		元素下标
		int index = -1;
//		查找
		for(int i = 0;i<arr.length;i++) {
			if (arr[i] == target) {
				index = i+1;
				break;
			}
			
		}
//		输出
		System.out.println("index:"+index);
		
	}
}
