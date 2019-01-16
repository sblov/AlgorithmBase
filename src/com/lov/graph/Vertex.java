package com.lov.graph;

/**
 * ¶¥µã
 * @author P1314023
 *
 */
public class Vertex {
	private  String value;
	public  boolean visited = false;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Vertex(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Vertex [value=" + value + "]";
	}
	
	
}
