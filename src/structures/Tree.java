package structures;

import node.TreeNode;

public class Tree<T> {
	private TreeNode<T> root;
	
	public Tree () {
		root = null;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}
	
	public int getDepth(TreeNode<T> r) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + getDepth(r.left), 1 + getDepth(r.right));
	}
}
