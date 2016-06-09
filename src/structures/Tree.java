package structures;

import node.TreeNode;

public class Tree {
	private TreeNode root;
	
	/**
	 * Constructor for a tree
	 * Uses integers only since there's no set way to compare generic types
	 */
	public Tree () {
		root = null;
	}
	
	/**
	 * Returns the root of the tree
	 * @return
	 */
	public TreeNode getRoot() {
		return root;
	}
	
	/**
	 * Adds a node to the tree
	 * @param rt root of the tree
	 * @param data value to be inserted
	 */
	public void addNode(TreeNode rt, int data) {
		TreeNode node = new TreeNode(data);
		
		if (rt == null) {
			rt = node;
		}
		else {
			if (node.getData() < data) {
				addNode(rt.left, data);
			}
			else {
				addNode(rt.right, data);
			}
		}
	}
	
	/**
	 * Gets the height/depth of the tree
	 * @param r root of the tree
	 * @return
	 */
	public int getDepth(TreeNode r) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + getDepth(r.left), 1 + getDepth(r.right));
	}
	
	/**
	 * Performs an in-order traversal of the tree
	 * @param rt
	 */
	public void inOrderTraversal(TreeNode rt) {
		if (rt != null) {
			inOrderTraversal(rt.left);
			System.out.println(rt.getData());
			inOrderTraversal(rt.right);
		}
	}
}
