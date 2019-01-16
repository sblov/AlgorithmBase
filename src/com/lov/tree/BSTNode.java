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
	 * ����ӽڵ�
	 * @param node
	 */
	public void add(BSTNode node) {
		if (node == null) {
			return;
		}
//		�жϴ���Ľڵ��ֵ�뵱ǰ�ڵ�ֵ�Ƚ�
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
//		--------------------ƽ�������++-----------------------------
//		�鿴�Ƿ�ƽ��
//		����ѡ��
		if (leftHeight() -rightHeight()>1) {
//			���ж��ڲ��������Ƿ���Ҫ��ת
//			������ת��������ת��˫��ת			
			if (lNode != null && lNode.leftHeight() < lNode.rightHeight()) {
				lNode.leftRotate();
				rightRotate();
			}else {
//			�ڼ���Ԫ��ʱ��ֻ��תһ�εĵ���ת
				
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
//		--------------------ƽ�������++-----------------------------
	}
	
	
	/**
	 * ����ת
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
	 * ����ת
	 */
	private void rightRotate() {
//		����һ���µĽڵ㣬ֵ���ڵ�ǰ�ڵ��ֵ
		BSTNode newRight = new BSTNode(data);
//		���½ڵ������������Ϊ��ǰ�ڵ��������
		newRight.rNode = rNode;
//		���½ڵ������������Ϊ��ǰ�ڵ����������������
		newRight.lNode = lNode.rNode;
//		�ѵ�ǰ�ڵ��ֵ��Ϊ���ӽڵ��ֵ
		data = lNode.data;
//		�ѵ�ǰ�ڵ������������Ϊ��������������
		lNode = lNode.lNode;
//		�ѵ�ǰ�Ľڵ������������Ϊ�½ڵ�
		rNode = newRight;
	}

	/**
	 * �������
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
	 * �ڵ�Ĳ���
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
	 * �������ڵ�
	 * @param value
	 * @return
	 */
	public BSTNode searchParent(int value) {
//		��ǰ�ڵ��ӽڵ�Ա�
		if ((this.lNode != null && this.lNode.data == value)||(this.rNode != null && this.rNode.data == value)) {
			return this;
		}
//		�ӽڵ�ݹ�Ա�
		if (this.data > value&& this.lNode != null) {
			return this.lNode.searchParent(value);
		}else if (this.data < value &&  this.rNode != null) {
			return this.rNode.searchParent(value);
		}
//		���ڵ�ǰ�ڵ���޸��ڵ�
		return null;
	}

	
}

