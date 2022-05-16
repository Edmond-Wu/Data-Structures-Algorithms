package structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TreeTest {
	private Tree tree;
	
	@Before
	public void setUp() {
		tree = new Tree();
	}
	
	@Test
	public void testAdding() {
		tree.addNode(10);
		Assert.assertEquals(10, tree.getRoot().getData());
		tree.addNode(5);
		Assert.assertEquals(5, tree.getRoot().getLeft().getData());
		tree.addNode(15);
		Assert.assertEquals(15, tree.getRoot().getRight().getData());
		tree.addNode(6);
		Assert.assertEquals(6, tree.getRoot().getLeft().getRight().getData());
		tree.addNode(12);
		Assert.assertEquals(12, tree.getRoot().getRight().getLeft().getData());
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
		Assert.assertTrue(tree.findTarget(tree.getRoot(), 5));
		Assert.assertTrue(tree.findTarget(tree.getRoot(), 12));
		Assert.assertTrue(tree.findTarget(tree.getRoot(), 6));
		Assert.assertTrue(tree.findTarget(tree.getRoot(), 15));
		Assert.assertFalse(tree.findTarget(tree.getRoot(), 7));
	}
	
	@Test
	public void testGetHeight() {
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(15);
		tree.addNode(6);
		tree.addNode(12);
		tree.addNode(7);
		Assert.assertEquals(3, tree.getDepth(tree.getRoot()));
	}
	
	@Test
	public void testDelete() {
		tree.addNode(5);
		tree.addNode(20);
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(15);
		Assert.assertFalse(tree.deleteNode(100));
		Assert.assertTrue(tree.deleteNode(1));
		Assert.assertTrue(tree.deleteNode(20));
		Assert.assertTrue(tree.deleteNode(5));
		Assert.assertTrue(tree.deleteNode(15));
		Assert.assertTrue(tree.deleteNode(2));
		Assert.assertFalse(tree.deleteNode(10));
	}
	
	@Test
	public void testInvert() {
		Assert.assertNull(Tree.invertTree(tree.getRoot()));
		tree.addNode(5);
		Assert.assertNotNull(Tree.invertTree(tree.getRoot()));
		tree.addNode(10);
		tree.addNode(1);
		Assert.assertEquals(1, tree.getRoot().getLeft().getData());
		Assert.assertEquals(10, tree.getRoot().getRight().getData());
		Tree.invertTree(tree.getRoot());
		Assert.assertEquals(10, tree.getRoot().getLeft().getData());
		Assert.assertEquals(1, tree.getRoot().getRight().getData());
	}
	
	@Test
	public void testSameTree() {
		Tree treeClone = new Tree();
		Assert.assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		treeClone.addNode(5);
		Assert.assertFalse(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(5);
		Assert.assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(10);
		treeClone.addNode(10);
		Assert.assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(1);
		treeClone.addNode(1);
		Assert.assertTrue(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
		tree.addNode(4);
		Assert.assertFalse(Tree.isSameTree(tree.getRoot(), treeClone.getRoot()));
	}

	@Test
	public void testVerticalOrderTraversal() {
		tree.addNode(5);
		tree.addNode(20);
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(15);
		System.out.println(Tree.verticalOrderTraversal(tree.getRoot()));
	}
}
