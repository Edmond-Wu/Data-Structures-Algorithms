package structures;

import node.TreeNode;

public class Tree<T> {
	private TreeNode<T> root;
	
	/**
	 * Constructor for a tree
	 */
	public Tree () {
		root = null;
	}
	
	/**
	 * Returns the root of the tree
	 * @return
	 */
	public TreeNode<T> getRoot() {
		return root;
	}
	
	/**
	 * Gets the height/depth of the tree
	 * @param r root of the tree
	 * @return
	 */
	public int getDepth(TreeNode<T> r) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + getDepth(r.left), 1 + getDepth(r.right));
	}
}
