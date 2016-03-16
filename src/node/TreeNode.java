package node;

public class TreeNode<T> extends Node<T> {
	
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T value) {
		super(value);
		left = null;
		right = null;
	}	
}
