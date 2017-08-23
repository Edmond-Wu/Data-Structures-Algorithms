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
	public void testInOrderTraversal() {
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(15);
		tree.addNode(6);
		tree.addNode(12);
		assertEquals(tree.iOTString(tree.getRoot()), "5 6 10 12 15 ");
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
}
