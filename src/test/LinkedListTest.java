package test;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import structures.LinkedList;

public class LinkedListTest extends TestCase {

	LinkedList<Integer> listOne;
	
	@Before
	public void setUp() {
		listOne = new LinkedList<>();
	}
	
	@Test
	public void testAddToFront() {
		assertNull(listOne.getHead());
		assertNull(listOne.getTail());
		assertEquals(listOne.getSize(), 0);
		listOne.addToFront(5);
		assertEquals(listOne.getHead(), (Integer)5);
		assertEquals(listOne.getTail(), listOne.getHead());
		assertEquals(listOne.getSize(), 1);
		listOne.addToFront(10);
		assertEquals(listOne.getHead(), (Integer)10);
		assertEquals(listOne.getTail(), (Integer)5);
		assertEquals(listOne.getSize(), 2);
	}
}
