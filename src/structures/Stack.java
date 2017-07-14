package structures;

import node.LLNode;

public class Stack<T> {
	private int size;
	private LLNode<T> head;
	
	/**
	 * Default constructor for a stack using a Linked List implementation
	 */
	public Stack() {
		head = null;
		size = 0;
	}
	
	/**
	 * Pushes a node to the stack
	 * @param data value to be pushed
	 */
	public void push(T data) {
		LLNode<T> node = new LLNode<T>(data);
		if (head == null) {
			head = node;
		}
		else {
			node.setNext(head);
			head = node;
		}
		size++;
	}
	
	/**
	 * Pops the top node off the stack and returns its data value
	 * @return
	 */
	public T pop() {
		T data;
		if (head == null) {
			return null;
		}
		else {
			data = head.getData();
			if (head.getNext() == null) {
				head = null;
			}
			else {
				head = head.getNext();
			}
			size--;
			return data;
		}
	}
	
	/**
	 * Gets the data of the head node without popping it
	 * @return
	 */
	public T peek() {
		return head.getData();
	}
	
	/**
	 * Gets the size of the stack
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Determines whether the stack is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
}
