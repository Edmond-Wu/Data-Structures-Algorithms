package structures;

import node.LLNode;

public class Queue<T> {
	
	private LLNode<T> head;
	private LLNode<T> tail;
	private int size;
	
	/**
	 * Default queue constructor, FIFO
	 */
	public Queue () {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Adds an item to the queue
	 * @param data
	 */
	public void enqueue(T data) {
		LLNode<T> new_node = new LLNode<T>(data);
		if (head == null) {
			head = new_node;
			tail = head;
			size++;
			return;
		}
		else {
			tail.next = new_node;
			tail = tail.next;
			size++;
		}
	}
	
	/**
	 * De-queues an item from the queue
	 * @return
	 */
	public T dequeue() {
		if (head == null) {
			return null;
		}
		else {
			LLNode<T> ptr = head;
			T data = ptr.getData();
			head = ptr.next;
			size--;
			return data;
		}
	}
	
	/**
	 * Returns the value of the next node in the queue
	 * @return
	 */
	public T peekHead() {
		return head.getData();
	}
	
	/**
	 * Gets the value of the last value in the queue
	 * @return
	 */
	public T peekTail() {
		return tail.getData();
	}
	
	/**
	 * Checks if the queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * Gets the size of the queue
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Prints the queue's contents
	 */
	public void printQ() {
		if (head == null) {
			return;
		}
		LLNode<T> ptr = head;
		while (ptr.next != null) {
			System.out.println(ptr.getData());
			ptr = ptr.next;
		}
	}
}
