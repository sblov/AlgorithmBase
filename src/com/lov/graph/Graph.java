package com.lov.graph;

import com.lov.linear.MyStack;

public class Graph {

	private Vertex[] vertexs ;
	private int currentSize;
	private int[][] adjMat;
	private MyStack stack = new MyStack();
	int currentIndex;
	
	
	public Graph(int size) {
		
		this.vertexs = new Vertex[size];
		this.adjMat = new int[size][size];
		for (int i = 0; i < size; i++) {
			adjMat[i][i] = 1;
		}
	}
	
	/**
	 * 添加顶点
	 * @param vertex
	 */
	public void addVertex(Vertex vertex) {
		vertexs[currentSize++] = vertex;
	}

	/**
	 * 添加边
	 * @param str1
	 * @param str2
	 */
	public void addEdge(String str1,String str2) {
		int index1=0;
		int index2 = 0;
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i].getValue() == str1) {
				index1 = i;
				continue;
			}
			if (vertexs[i].getValue() == str2) {
				index2 = i;
				continue;
			}
			
		}
//		无向图两个顶点都能相通
		adjMat[index1][index2] = 1;
		adjMat[index2][index1] = 1;
	}
	
	public void showGrap() {
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = 0; j < vertexs.length; j++) {
				System.out.print(adjMat[i][j]+"-");
			}
			System.out.println();
		}
	}
	
	/**
	 * 深度优先搜索算法遍历图
	 */
	public void dfs() {
//		将第一个顶点设置为为遍历
		vertexs[0].visited = true;
//		将第一个顶点放入栈中
		stack.push(0);
//		打印第一个顶点值
		System.out.println(vertexs[0]);
//		判断当前栈是否为空
		out:while (!stack.isEmpty()) {
//			二维邻接表中遍历，看剩下的顶点能否遍历
			for (int i = 0; i < vertexs.length; i++) {
				if (adjMat[currentIndex][i] == 1 && vertexs[i].visited == false) {
					stack.push(i);
					vertexs[i].visited = true;
					System.out.println(vertexs[i]);
					currentIndex = stack.peek();
//					
//					continue out;
				}
			}
			
//			栈顶出栈
			stack.pop();
			if (!stack.isEmpty()) {
//				当前坐标为栈顶值
				currentIndex = stack.peek();
//				System.out.println("o"+vertexs[currentIndex]);
			}
		}
	}
}
