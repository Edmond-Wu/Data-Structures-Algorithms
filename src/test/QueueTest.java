package test;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import structures.Queue;

public class QueueTest extends TestCase {
	private Queue<Integer> queue;
	
	@Before
	public void setUp() {
		queue = new Queue<Integer>();
	}
	
	@Test
	public void testQueue() {
		queue.enqueue(10);
		queue.enqueue(5);
		assertEquals("10,5", queue.toString());
		assertEquals(queue.getSize(), 2);
		int front = queue.peek();
		assertEquals(10, front);
		int tail = queue.getTail().getData();
		assertEquals(tail, 5);
		int dequeued = queue.dequeue();
		assertEquals(dequeued, 10);
		int newFront = queue.peek();
		assertEquals(newFront, 5);
	}
}
