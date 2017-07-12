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
	 * @return root
	 */
	public TreeNode getRoot() {
		return root;
	}
	
	/**
	 * Adds a node to the tree
	 * @param data value to be inserted
	 */
	public void addNode(int data) {
		TreeNode node = new TreeNode(data);
		if (root == null) {
			root = node;
			return;
		}
		TreeNode current = root;
		TreeNode parent;
		while (true) {
			parent = current;
			if (data < current.getData()) {
				current = current.getLeft();
				if (current == null) {
					parent.setLeft(node);
					return;
				}
			}
			else {
				current = current.getRight();
				if (current == null) {
					parent.setRight(node);
					return;
				}
			}
		}
	}
	
	/**
	 * Deletes a node from the tree
	 * @param data value to be deleted
	 * @return true if deleted, false if value does not exist in tree
	 */
	public boolean deleteNode(int data) {
		TreeNode parent = root;
		TreeNode current = root;
		boolean isLeftChild = false;
		
		while(current.getData() != data){
			parent = current;
			if (current.getData() > data){
				isLeftChild = true;
				current = current.getLeft();
			}
			else {
				isLeftChild = false;
				current = current.getRight();
			}
			//node is not found
			if (current == null){
				return false;
			}
		}
		
		//node is found
		//Case 1: if node to be deleted has no children
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root){
				root = null;
			}
			if (isLeftChild) {
				parent.setLeft(null);
			}
			else {
				parent.setRight(null);
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if (current.getRight() == null) {
			if (current == root) {
				root = current.getLeft();
			}
			else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			}
			else {
				parent.setRight(current.getLeft());
			}
		}
		else if (current.getLeft() == null) {
			if (current == root) {
				root = current.getRight();
			}
			else if (isLeftChild) {
				parent.setLeft(current.getRight());
			}
			else {
				parent.setRight(current.getRight());
			}
		}
		else {
			//now we have found the minimum element in the right sub tree
			TreeNode successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			}
			else if (isLeftChild) {
				parent.setLeft(successor);
			}
			else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
		}		
		return true;	
	}
	
	/**
	 * Helper method for deleting nodes
	 * @param tbd node to be deleted
	 * @return successor node
	 */
	public TreeNode getSuccessor(TreeNode tbd) {
		TreeNode successor = null;
		TreeNode successor_parent = null;
		TreeNode current = tbd.getRight();
		
		while (current != null) {
			successor_parent = successor;
			successor = current;
			current = current.getRight();
		}
		
		//check if the successor has a right child (cannot have left)
		//add it to the left of successor_parent if it has a right child
		if (successor != tbd.getRight()) {
			successor_parent.setLeft(successor.getRight());
			successor.setRight(tbd.getRight());
		}
		return successor;
	}
	
	/**
	 * Searches the tree for the target number
	 * @param rt root node
	 * @param data number to be searched
	 * @return true if found, false otherwise
	 */
	public boolean findTarget(TreeNode rt, int data) {
		if (rt == null) {
			return false;
		}
		if (rt.getData() == data) {
			return true;
		}
		else {
			if (data < rt.getData()) {
				return findTarget(rt.getLeft(), data);
			}
			else {
				return findTarget(rt.getRight(), data);
			}
		}
	}

	/**
	 * Inverts a binary tree
	 * @param rt root of tree
	 * @return root of new inverted tree
	 */
	public TreeNode invertTree(TreeNode rt) {
		if (rt == null || (rt.getLeft() == null && rt.getRight() == null)) {
			return rt;
		}
		TreeNode temp = rt.getLeft();
		rt.setLeft(rt.getRight());
        rt.setRight(temp);
		invertTree(rt.getLeft());
		invertTree(rt.getRight());
		return rt;
	}

	/**
	 * Gets the height/depth of the tree
	 * @param rt root of the tree
	 * @return
	 */
	public int getDepth(TreeNode rt) {
		if (rt == null) {
			return 0;
		}
		return Math.max(1 + getDepth(rt.getLeft()), 1 + getDepth(rt.getRight()));
	}

    /**
     * Checks if 2 trees are the same structure-wise and value-wise
     * @param p root of first tree
     * @param q root of second tree
     * @return true if they're the same, false if not
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else {
            return (!(p == null || q == null) && p.getData() == q.getData() && (isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight())));
        }
    }
	
	/**
	 * Performs an in-order traversal of the tree
	 * @param rt root of tree
	 */
	public void inOrderTraversal(TreeNode rt) {
		if (rt != null) {
			inOrderTraversal(rt.getLeft());
			System.out.print(rt.getData() + " ");
			inOrderTraversal(rt.getRight());
		}
	}
	
	
	/**
	 * Performs a pre-order traversal of the tree
	 * @param rt root of tree
	 */
	public void preOrderTraversal(TreeNode rt) {
		if (rt != null) {
			System.out.print(rt.getData() + " ");
			inOrderTraversal(rt.getLeft());
			inOrderTraversal(rt.getRight());
		}
	}
	
	/**
	 * Performs a post-order traversal of the tree
	 * @param rt root of tree
	 */
	public void postOrderTraversal(TreeNode rt) {
		if (rt != null) {
			inOrderTraversal(rt.getLeft());
			inOrderTraversal(rt.getRight());
			System.out.print(rt.getData() + " ");
		}
	}
}
