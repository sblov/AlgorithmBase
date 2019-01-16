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
//		ʹ�����鴴�����ɶ�����
		List<Node> nodes = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			nodes.add(new Node(arr[i]));
		}
		while (nodes.size() >1) {
//			Nodeʵ��Comparable,����
			Collections.sort(nodes);
//			ȡȨֵ��С������
			Node lNode = nodes.get(0);
			Node rNode = nodes.get(1);
//			�����½ڵ�
			Node root = new Node(lNode.data+rNode.data);
			root.lNode = lNode;
			root.rNode = rNode;
//			�Ƴ���ˢ��λ���±�
			nodes.remove(0);
			nodes.remove(0);


//			�½ڵ��������
			nodes.add(root);
		}
//		System.out.println(nodes);
		return nodes.get(0);
	}
	
}
