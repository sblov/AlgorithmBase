package com.lov;


import com.lov.tree.BSTNode;
import com.lov.tree.BinarySortTree;
import com.lov.tree.ThreadBinaryTree;
import com.lov.tree.ThreadNode;

public class Test {

	public static void main(String[] args) {
		
//		int[] arr = {8,9,6,7,5,4,10};
//		int[] arr = {2,1,4,3,5,6};
		int[] arr = {8,9,5,4,6,7};
		BinarySortTree bSortTree = new BinarySortTree();
		
		for(int i: arr) {
			bSortTree.add(new BSTNode(i));
		}
		
		System.out.println(bSortTree.searchParent(7));
		
		System.out.println(bSortTree.root);
		
		
	}
	
}
