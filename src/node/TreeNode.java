package node;

public class TreeNode {
	
	private TreeNode left;
	private TreeNode right;
	private int data;
	
	/**
	 * Node designed for an integer binary tree representation
	 * @param value
	 */
	public TreeNode(int value) {
		left = null;
		right = null;
		data = value;
	}
	
	/**
	 * Gets the data held by the tree node
	 * @return
	 */
	public int getData() {
		return data;
	}
	
	/**
	 * Gets left child of tree
	 * @return
	 */
	public TreeNode getLeft() {
		return left;
	}
	
	/**
	 * Gets right child of tree
	 * @return
	 */
	public TreeNode getRight() {
		return right;
	}
	
	/**
	 * Changes left child of tree
	 * @param n new node
	 */
	public void setLeft(TreeNode n) {
		left = n;
	}
	
	/**
	 * Changes right child of tree
	 * @param n new node
	 */
	public void setRight(TreeNode n) {
		right = n;
	}
}
