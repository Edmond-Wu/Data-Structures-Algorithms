package structures;

import node.LLNode;

public class LinkedList<T> {
	private LLNode<T> head;
	private LLNode<T> tail;
	private int size;
	
	/**
	 * Constructor for a linked list
	 */
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Returns the head of the linked list (first node)
	 * @return
	 */
	public T getHead() {
		if (head == null) {
			return null;
		}
		return head.getData();
	}
	
	/**
	 * Returns the tail (end node) of the list
	 * @return
	 */
	public T getTail() {
		if (tail == null) {
			return null;
		}
		return tail.getData();
	}
	
	/**
	 * Gets the size of the linked list (number of nodes in list)
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds a node to the front of the list
	 * @param data
	 */
	public void addToFront(T data) {
		if (head == null) {
			head = new LLNode<T>(data);
			tail = head;
		}
		else {
			LLNode<T> new_head = new LLNode<T>(data);
			new_head.next = head;
			head = new_head;
		}
		size++;
	}
	
	/**
	 * Adds a node to the back
	 * @param data
	 */
	public void addToBack(T data) {
		if (head == null) {
			head = new LLNode<T>(data);
			tail = head;
		}
		else {
			LLNode<T> added = new LLNode<T>(data);
			LLNode<T> ptr = head;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = added;
			tail = ptr.next;
		}
		size++;
	}
	
	/**
	 * Removes the head of the list
	 */
	public void removeHead() {
		if (head == null) {
			return;
		}
		else if (head.next == null) {
			head = null;
			tail = null;
			return;
		}
		else {
			head = head.next;
		}
		size--;
	}
	
	/**
	 * Removes the end of the list
	 */
	public void removeTail() {
		if (tail == null) {
			return;
		}
		else {
			LLNode<T> ptr = head;
			while (ptr.next != tail) {
				ptr = ptr.next;
			}
			ptr.next = null;
			tail = ptr;
		}
		size--;
	}
	
	/**
	 * Prints the list's contents
	 */
	public void printLL() {
		if (head == null) {
			return;
		}
		LLNode<T> ptr = head;
		while (ptr != null) {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}
