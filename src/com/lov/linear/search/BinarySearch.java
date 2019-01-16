package com.lov.linear.search;

/*
 * 二分法查找
 * 将排好序的数据，取中间值与查找数据对比，选择一边，再进行相同方式比较
 */
public class BinarySearch {

	public static void main(String[] args) {
//		目标数据
		int[] arr = {1,2,3,4,5,6,7,8,9};
//		目标元素
		int target = 8;
//		查找开始位置
		int begin = 0;
//		查找结束位置
		int end = arr.length-1;
//		查找中间位置
		int mid = (begin+end/2);
//		目标位置
		int index = -1;
//		循环查找
		while (true) {
//			判断
			if (arr[mid] == target) {
				index = mid+1;
				break;
			}else {
//				目标元素小于中间位置
				if (arr[mid] > target) {
//					end为中间位置前一个位
					end = mid-1;
				}else {
//					目标元素大于中间位置
//					begin为中间位置后一个位
					begin = mid+1;
				}
//				求新的中间值
				mid = (begin+end)/2;
			}
			
		}
//		输出
		System.out.println("index:"+index);
	}
	
}
