package com.lov.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeTest {

	public static void main(String[] args) {
		int[] arr = {3,5,7,8,11,14,23,29};
//		createHuffmanTree(arr);
		System.out.println( createHuffmanTree(arr).rNode);
	}
	
	public static Node createHuffmanTree(int[] arr) {
//		使用数组创建若干二叉树
		List<Node> nodes = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			nodes.add(new Node(arr[i]));
		}
		while (nodes.size() >1) {
//			Node实现Comparable,排序
			Collections.sort(nodes);
//			取权值最小的两个
			Node lNode = nodes.get(0);
			Node rNode = nodes.get(1);
//			设置新节点
			Node root = new Node(lNode.data+rNode.data);
			root.lNode = lNode;
			root.rNode = rNode;
//			移除后刷新位置下标
			nodes.remove(0);
			nodes.remove(0);


//			新节点加入排序
			nodes.add(root);
		}
//		System.out.println(nodes);
		return nodes.get(0);
	}
	
}
