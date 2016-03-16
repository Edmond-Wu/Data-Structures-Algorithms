package structures;

import node.LLNode;

public class LinkedList<T> {
	private LLNode<T> head;
	private LLNode<T> tail;
	private int size;
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public T getHead() {
		return head.getData();
	}
	
	public T getTail() {
		return tail.getData();
	}
	
	public int getSize() {
		return size;
	}
	
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
