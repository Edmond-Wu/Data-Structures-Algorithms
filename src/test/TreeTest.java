package test;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import structures.Tree;

public class TreeTest extends TestCase {
	private Tree tree;
	
	@Before
	public void setUp() {
		tree = new Tree();
	}
	
	@Test
	public void testAdding() {
		tree.addNode(10);
		assertEquals(tree.getRoot().getData(), 10);
		tree.addNode(5);
		assertEquals(tree.getRoot().getLeft().getData(), 5);
		tree.addNode(15);
		assertEquals(tree.getRoot().getRight().getData(), 15);
		tree.addNode(6);
		assertEquals(tree.getRoot().getLeft().getRight().getData(), 6);
		tree.addNode(12);
		assertEquals(tree.getRoot().getRight().getLeft().getData(), 12);
	}
	
	@Test
	public void testTraversals() {
		Tree.inOrderTraversal(tree.getRoot());
		Tree.preOrderTraversal(tree.getRoot());
		Tree.postOrderTraversal(tree.getRoot());
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(15);
		tree.addNode(6);
		tree.addNode(12);
		Tree.inOrderTraversal(tree.getRoot());
		System.out.println();
		Tree.preOrderTraversal(tree.getRoot());
		System.out.println();
		Tree.postOrderTraversal(tree.getRoot());
	}
	
	@Test
	public void testSearch() {
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(15);
		tree.addNode(6);
		tree.addNode(12);
		assertEquals(tree.findTarget(tree.getRoot(), 5), true);
		assertEquals(tree.findTarget(tree.getRoot(), 12), true);
		assertEquals(tree.findTarget(tree.getRoot(), 6), true);
		assertEquals(tree.findTarget(tree.getRoot(), 15), true);
		assertEquals(tree.findTarget(tree.getRoot(), 7), false);
	}
	
	@Test
	public void testGetHeight() {
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(15);
		tree.addNode(6);
		tree.addNode(12);
		tree.addNode(7);
		assertEquals(tree.getDepth(tree.getRoot()), 3);
	}
	
	@Test
	public void testDelete() {
		tree.addNode(5);
		tree.addNode(20);
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(15);
		assertFalse(tree.deleteNode(100));
		assertTrue(tree.deleteNode(1));
		assertTrue(tree.deleteNode(20));
		assertTrue(tree.deleteNode(5));
		assertTrue(tree.deleteNode(15));
		assertTrue(tree.deleteNode(2));
		assertFalse(tree.deleteNode(10));
	}
	
	@Test
	public void testInvert() {
		assertNull(Tree.invertTree(tree.getRoot()));
		tree.addNode(5);
		assertNotNull(Tree.invertTree(tree.getRoot()));
		tree.addNode(10);
		tree.addNode(1);
		assertEquals(tree.getRoot().getLeft().getData(), 1);
		assertEquals(tree.getRoot().getRight().getData(), 10);
		Tree.invertTree(tree.getRoot());
		assertEquals(tree.getRoot().getLeft().getData(), 10);
		assertEquals(tree.getRoot().getRight().getData(), 1);
	}
	
	@Test
	public void testSameTree() {
		Tree treeClone = new Tree();
		assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		treeClone.addNode(5);
		assertFalse(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(5);
		assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(10);
		treeClone.addNode(10);
		assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(1);
		treeClone.addNode(1);
		assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(4);
		assertFalse(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
	}
}
