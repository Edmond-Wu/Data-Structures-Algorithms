package structures;

import node.LLNode;

public class Queue<T> {
	
	private LLNode<T> head;
	private LLNode<T> tail;
	private int size;
	
	public Queue () {
		head = null;
		tail = null;
		size = 0;
	}
	
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
	
	public T peekHead() {
		return head.getData();
	}
	
	public T peekAss() {
		return tail.getData();
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	public int getSize() {
		return size;
	}
	
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
