package com.lov.tree;

public class BinarySortTree {

	public BSTNode root;
	
	public BinarySortTree() {
	
	}
	public int height() {
		return root==null?0:root.height();
	}
	
//	添加子节点
	public void add(BSTNode node) {
		if (root == null) {
			root = node;
		}
		else {
			root.add(node);
		}
	}
//	中序遍历
	public void midShow() {
		root.midShow(root);
	}

//	查找节点
	public BSTNode search(int value) {
		if(root == null) {
			return null;
		}
		return root.search(value);
	}
	
//	删除节点
	public void delete(int value) {
		if (root == null) {
			return;
		}
//		找到这个节点
		BSTNode target = search(value);
		if (target == null) {
			return;
		}
//		找到该节点子节点
		BSTNode parent = searchParent(value);
//		删除叶子节点
		if (target.lNode == null&& target.rNode==null) {
//			父节点的左节点
			if (parent.lNode!= null && parent.lNode.data == value) {
				parent.lNode = null;
			}
//			父节点的右节点
			if (parent.rNode!=null&&parent.rNode.data == value) {
				parent.rNode = null;
			}
//		删除有两个子节点的节点
		}else if (target.lNode != null && target.rNode != null) {
//			删除右子树中最小的节点
			int min = deleteMin(target.rNode);
//			替换目标节点
			target.data = min;
//		删除只有一个节点的节点
		}else {
//			有左子节点
			if (target.lNode != null) {
				if (parent.lNode.data == value) {
					parent.lNode = target.lNode;
				}else {
					parent.rNode = target.lNode;
				}
//			有右子节点
			}else {
				if (parent.lNode.data == value) {
					parent.lNode = target.rNode;
				}else {
					parent.rNode = target.rNode;
				}
			}
		}
	}

	/**
	 * 删除树中最小的节点
	 * @param rNode
	 * @return
	 */
	private int deleteMin(BSTNode node) {
		
		BSTNode target = node;
		while (target.lNode != null) {
			target = target.lNode;
		}
		delete(target.data);
		
		return target.data;
	}
	
	/**
	 * 查找父节点
	 * @param value
	 * @return
	 */
	public BSTNode searchParent(int value) {
		if (root == null) {
			return null;
		}
		return root.searchParent(value);
	}
	
	
}
