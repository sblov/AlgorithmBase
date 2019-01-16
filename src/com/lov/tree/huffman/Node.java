package com.lov.tree.huffman;

public class Node  implements Comparable<Node>{

	Byte data;
	int weight;
	Node lNode;
	Node rNode;
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	public Node(Byte data,int weight) {
	
			this.data = data;
			this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		
		return this.weight - o.weight ;
	}
	
}
