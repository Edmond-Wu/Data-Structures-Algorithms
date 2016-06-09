package node;

public class TreeNode<T> extends Node<T> {
	
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	/**
	 * Node designed for a binary tree representation
	 * @param value
	 */
	public TreeNode(T value) {
		super(value);
		left = null;
		right = null;
	}	
}
