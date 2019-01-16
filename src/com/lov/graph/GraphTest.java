package com.lov.graph;

public class GraphTest {

	public static void main(String[] args) {
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");

		Graph graph  =new Graph(5);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		
		graph.addEdge("B", "A");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		graph.addEdge("C", "A");
		
		graph.showGrap();
		
		graph.dfs();
	}
	
}
