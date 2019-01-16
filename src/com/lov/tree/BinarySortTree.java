package com.lov.tree;

public class BinarySortTree {

	public BSTNode root;
	
	public BinarySortTree() {
	
	}
	public int height() {
		return root==null?0:root.height();
	}
	
//	����ӽڵ�
	public void add(BSTNode node) {
		if (root == null) {
			root = node;
		}
		else {
			root.add(node);
		}
	}
//	�������
	public void midShow() {
		root.midShow(root);
	}

//	���ҽڵ�
	public BSTNode search(int value) {
		if(root == null) {
			return null;
		}
		return root.search(value);
	}
	
//	ɾ���ڵ�
	public void delete(int value) {
		if (root == null) {
			return;
		}
//		�ҵ�����ڵ�
		BSTNode target = search(value);
		if (target == null) {
			return;
		}
//		�ҵ��ýڵ��ӽڵ�
		BSTNode parent = searchParent(value);
//		ɾ��Ҷ�ӽڵ�
		if (target.lNode == null&& target.rNode==null) {
//			���ڵ����ڵ�
			if (parent.lNode!= null && parent.lNode.data == value) {
				parent.lNode = null;
			}
//			���ڵ���ҽڵ�
			if (parent.rNode!=null&&parent.rNode.data == value) {
				parent.rNode = null;
			}
//		ɾ���������ӽڵ�Ľڵ�
		}else if (target.lNode != null && target.rNode != null) {
//			ɾ������������С�Ľڵ�
			int min = deleteMin(target.rNode);
//			�滻Ŀ��ڵ�
			target.data = min;
//		ɾ��ֻ��һ���ڵ�Ľڵ�
		}else {
//			�����ӽڵ�
			if (target.lNode != null) {
				if (parent.lNode.data == value) {
					parent.lNode = target.lNode;
				}else {
					parent.rNode = target.lNode;
				}
//			�����ӽڵ�
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
	 * ɾ��������С�Ľڵ�
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
	 * ���Ҹ��ڵ�
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
