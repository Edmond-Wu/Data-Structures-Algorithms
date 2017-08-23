package test;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import structures.LinkedList;

public class LinkedListTest extends TestCase {

	private LinkedList<Integer> listOne, listTwo;
	
	@Before
	public void setUp() {
		listOne = new LinkedList<>();
		listTwo = new LinkedList<>();
	}
	
	@Test
	public void testAddToFront() {
		assertNull(listOne.getHead());
		assertNull(listOne.getTail());
		assertEquals(listOne.getSize(), 0);
		listOne.addToFront(5);
		assertEquals(listOne.getHead().getData(), (Integer)5);
		assertEquals(listOne.getTail().getData(), listOne.getHead().getData());
		assertEquals(listOne.getSize(), 1);
		listOne.addToFront(10);
		assertEquals(listOne.getHead().getData(), (Integer)10);
		assertEquals(listOne.getTail().getData(), (Integer)5);
		assertEquals(listOne.getSize(), 2);
	}
	
	@Test
	public void testAddToBack() {
		listOne.addToBack(5);
		assertEquals(listOne.getHead().getData(), (Integer)5);
		assertEquals(listOne.getTail().getData(), listOne.getHead().getData());
		assertEquals(listOne.getSize(), 1);
		listOne.addToBack(10);
		assertEquals(listOne.getHead().getData(), (Integer)5);
		assertEquals(listOne.getTail().getData(), (Integer)10);
		assertEquals(listOne.getSize(), 2);
	}
	
	@Test
	public void testReverse() {
		listOne.addToBack(1);
		listOne.reverse();
		assertEquals(listOne.toString(), "1");
		for (int i = 2; i <= 6; i++) {
			listOne.addToBack(i);
		}
		assertEquals(listOne.toString(), "1,2,3,4,5,6");
		listOne.reverse();
		assertEquals(listOne.toString(), "6,5,4,3,2,1");
	}
	
	@Test
	public void testMerge() {
		for (int i = 1; i <= 5; i++) {
			listOne.addToBack(i);
		}
		for (int j = 6; j <= 10; j++) {
			listTwo.addToBack(j);
		}
		assertEquals(LinkedList.getStringFromNode(LinkedList.merge(listOne.getHead(), listTwo.getHead())), "1 2 3 4 5 6 7 8 9 10 ");
		assertEquals(LinkedList.getStringFromNode(LinkedList.merge(listTwo.getHead(), listOne.getHead())), "1 2 3 4 5 6 7 8 9 10 ");
		LinkedList<Integer> listThree = new LinkedList<>();
		LinkedList<Integer> listFour = new LinkedList<>();
		for (int a = 1; a <= 10; a++) {
			if (a % 2 == 0) {
				listFour.addToBack(a);
			}
			else {
				listThree.addToBack(a);
			}
		}
		assertEquals(LinkedList.getStringFromNode(LinkedList.merge(listThree.getHead(), listFour.getHead())), "1 2 3 4 5 6 7 8 9 10 ");
		assertEquals(LinkedList.getStringFromNode(LinkedList.merge(listFour.getHead(), listThree.getHead())), "1 2 3 4 5 6 7 8 9 10 ");
	}
}
