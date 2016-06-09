package node;

public class TreeNode {
	
	public TreeNode  left;
	public TreeNode  right;
	private int data;
	
	/**
	 * Node designed for a binary tree representation
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
}
