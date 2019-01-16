package com.lov.linear;
/*
 * Recursive 递归
 * 	德罗斯特效应图：相当于拿着镜子照镜子
 */
public class Recursive {
	
	public static void main(String[] args) {
		
		print(10);
	}
	
	public static void print(int n) {
		if (n>=0) {
			System.out.println(n);
			print(n-1);			
		}
	}
	
}
