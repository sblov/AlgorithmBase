package com.lov.linear;
/*
 * 汉诺塔
 */
public class Hanoi {

	public static void main(String[] args) {
		
		hanoi(5, 'a', 'b', 'c');
	}
	
	/**
	 * @param n	当前需要移动的元素
	 * @param from	起始位置
	 * @param in	中间的位置
	 * @param to	到达位置
	 */
//	对于汉诺塔而言，无论要移动多少元素，最终都会追溯到移动一个与移动两个，所以只需要分析两个的移动即可
	public static void hanoi(int n,char from,char in,char to) {
//		当移动的为第一个元素时
		if(n==1) {
			System.out.println("1:from "+from+" to "+to);
		}else {
//			移动第n个元素时，类似第二个元素依次递归
			hanoi(n-1, from, to, in);
			System.out.println(n+":from "+from+" to "+to);
			hanoi(n-1, in,from, to);
		}
	}
}
