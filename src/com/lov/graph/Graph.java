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
	 * ��Ӷ���
	 * @param vertex
	 */
	public void addVertex(Vertex vertex) {
		vertexs[currentSize++] = vertex;
	}

	/**
	 * ��ӱ�
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
//		����ͼ�������㶼����ͨ
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
	 * ������������㷨����ͼ
	 */
	public void dfs() {
//		����һ����������ΪΪ����
		vertexs[0].visited = true;
//		����һ���������ջ��
		stack.push(0);
//		��ӡ��һ������ֵ
		System.out.println(vertexs[0]);
//		�жϵ�ǰջ�Ƿ�Ϊ��
		out:while (!stack.isEmpty()) {
//			��ά�ڽӱ��б�������ʣ�µĶ����ܷ����
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
			
//			ջ����ջ
			stack.pop();
			if (!stack.isEmpty()) {
//				��ǰ����Ϊջ��ֵ
				currentIndex = stack.peek();
//				System.out.println("o"+vertexs[currentIndex]);
			}
		}
	}
}
