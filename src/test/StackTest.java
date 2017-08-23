package test;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import structures.Stack;

public class StackTest extends TestCase {
	private Stack<Integer> stk;
	
	@Before
	public void setUp() {
		stk = new Stack<Integer>();
	}
	
	@Test
	public void testStack() {
		assertTrue(stk.isEmpty());
		stk.push(10);
		assertFalse(stk.isEmpty());
		stk.push(5);
		assertEquals(stk.getSize(), 2);
		int peeked = stk.peek();
		assertEquals(peeked, 5);
		int popped = stk.pop();
		assertEquals(popped, 5);
		int newPeeked = stk.peek();
		assertEquals(newPeeked, 10);
	}
}
