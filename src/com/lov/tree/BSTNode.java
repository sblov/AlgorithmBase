package com.lov.tree;


public class BSTNode {

	int data;
	BSTNode lNode;
	BSTNode rNode;
	
	public BSTNode(int data) {
		this.data = data;
	}

	public int height() {
		return Math.max(lNode==null?0:lNode.height(), rNode==null?0:rNode.height())+1;
	}
	
	public int leftHeight() {
		if(lNode == null) {
			return 0 ;
		}
		return lNode.height();
	}
	
	public int rightHeight() {
		if(rNode == null) {
			return 0 ;
		}
		return rNode.height();
	}
	
	/**
	 * 添加子节点
	 * @param node
	 */
	public void add(BSTNode node) {
		if (node == null) {
			return;
		}
//		判断传入的节点的值与当前节点值比较
		if(node.data < this.data) {
			if(this.lNode == null) {
				this.lNode = node;
			}else {
				lNode.add(node);
			}
		}else {
			if(this.rNode == null) {
				this.rNode = node;
			}else {
				rNode.add(node);
			}
		}
//		--------------------平衡二叉树++-----------------------------
//		查看是否平衡
//		进行选择
		if (leftHeight() -rightHeight()>1) {
//			在判断内部的子树是否需要旋转
//			先左旋转，再右旋转，双旋转			
			if (lNode != null && lNode.leftHeight() < lNode.rightHeight()) {
				lNode.leftRotate();
				rightRotate();
			}else {
//			在加入元素时，只旋转一次的单旋转
				
				rightRotate();
			}
		}
		if (leftHeight() -rightHeight()<-1) {
			if (rNode != null && rNode.leftHeight() > rNode.rightHeight()) {
				rNode.rightRotate();
				leftRotate();
			}else {
				
				leftRotate();
			}
		}
//		--------------------平衡二叉树++-----------------------------
	}
	
	
	/**
	 * 左旋转
	 */
	private void leftRotate() {

		BSTNode newLeft = new BSTNode(data);

		newLeft.lNode = lNode;

		newLeft.rNode = rNode.lNode;

		data = rNode.data;

		rNode = rNode.rNode;

		lNode = newLeft;
		
	}

	/**
	 * 
	 * 右旋转
	 */
	private void rightRotate() {
//		创建一个新的节点，值等于当前节点的值
		BSTNode newRight = new BSTNode(data);
//		把新节点的右子树设置为当前节点的右子树
		newRight.rNode = rNode;
//		把新节点的左子树设置为当前节点的左子树的右子树
		newRight.lNode = lNode.rNode;
//		把当前节点的值设为左子节点的值
		data = lNode.data;
//		把当前节点的左子树设置为左子树的左子树
		lNode = lNode.lNode;
//		把当前的节点的右子树设置为新节点
		rNode = newRight;
	}

	/**
	 * 中序遍历
	 * @param node
	 */
	public void midShow(BSTNode node) {
		if (node == null) {
			return;
		}
		midShow(node.lNode);
		System.out.println(node.data);
		midShow(node.rNode);
	}

	/**
	 * 节点的查找
	 * @param value
	 * @return 
	 */
	public BSTNode search(int value) {
		if (value == data) {
			return this; 
		}
		
		if (value < data) {
			if (lNode == null) {
				return null;
			}
			return lNode.search(value);
		}else {
			if (rNode == null) {
				return null;
			}
			return rNode.search(value);
		}
		
	}

	@Override
	public String toString() {
		return "BSTNode [data=" + data + "]";
	}

	/**
	 * 搜索父节点
	 * @param value
	 * @return
	 */
	public BSTNode searchParent(int value) {
//		但前节点子节点对比
		if ((this.lNode != null && this.lNode.data == value)||(this.rNode != null && this.rNode.data == value)) {
			return this;
		}
//		子节点递归对比
		if (this.data > value&& this.lNode != null) {
			return this.lNode.searchParent(value);
		}else if (this.data < value &&  this.rNode != null) {
			return this.rNode.searchParent(value);
		}
//		等于当前节点或无父节点
		return null;
	}

	
}

