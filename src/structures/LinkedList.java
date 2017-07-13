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
	 * @return data found in the head node
	 */
	public LLNode<T> getHead() {
		if (head == null) {
			return null;
		}
		return head;
	}
	
	/**
	 * Returns the tail (end node) of the list
	 * @return data found in the tail node
	 */
	public LLNode<T> getTail() {
		if (tail == null) {
			return null;
		}
		return tail;
	}

	/**
	 * Gets the size of the linked list (number of nodes in list)
	 * @return size of the list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds a node to the front of the list
	 * @param data value of node to be added
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
	 * @param data value of node to be added
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
	 * @return value of removed node
	 */
	public T removeHead() {
		if (head == null) {
			return null;
		}
		else {
			T data = head.getData();
			if (head.next == null) {
				head = null;
				tail = null;
			}
			else {
				head = head.next;
			}
			size--;
			return data;
		}
	}

	/**
	 * Removes the tail of the linked list
	 * @return value of removed node
	 */
	public T removeTail() {
		if (tail == null) {
			return null;
		}
		else {
			T data = tail.getData();
			LLNode<T> ptr = head;
			while (ptr.next != tail) {
				ptr = ptr.next;
			}
			ptr.next = null;
			tail = ptr;
			size--;
			return data;
		}
	}

	/**
	 * Reverses the linked list
	 */
	public void reverse() {
		if (head == null || head.next == null) {
			return;
		}
		LLNode<T> before = null;
		LLNode<T> tmp = head;
		while (tmp != null) {
			LLNode<T> next = tmp.next; //make copy of the next node

			//change pointers
			tmp.next = before;
			before = tmp;
			tmp = next;
		}
		head = before; //set head to last node
	}

	/**
	 * Algorithm for merging 2 sorted integer linked lists
	 * @param headA head of first list
	 * @param headB head of second list
	 * @return head of the new merged list
	 */
	public static LLNode<Integer> merge(LLNode<Integer> headA, LLNode<Integer> headB) {
		if (headA == null || headB == null) {
	        if (headA != null) {
	            return headA;
	        }
	        if (headB != null) {
	        	return headB;
	        }
	        return null;
	    }
	    LLNode<Integer> newHead, newPtr;
	    //start new head at whichever one has the smallest starting value
	    if (headA.getData() < headB.getData()) {
	        newHead = headA;
	    }
	    else {
	        newHead = headB;
	    }
	    newPtr = newHead;
	    LLNode<Integer> ptrA = headA, ptrB = headB;
	    //iterate through each list and add to the new list
	    while (ptrA != null && ptrB != null) {
	        if (ptrA.getData() < ptrB.getData()) {
	            newPtr.next = ptrA;
	            ptrA = ptrA.next;
	        }
	        else {
	            newPtr.next = ptrB;
	            ptrB = ptrB.next;
	        }
	        newPtr = newPtr.next;
	    }
	    if (ptrA == null) {
	        newPtr.next = ptrB;
	    }
	    else {
	        newPtr.next = ptrA;
	    }
	    return newHead;
	}
	
	/**
	 * Prints a list given a starting node
	 * @param node
	 */
	public static<T> void printList(LLNode<T> node) {
		if (node == null) {
			return;
		}
		LLNode<T> ptr = node;
		while (ptr != null) {
			System.out.print(ptr.getData() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Stores contents of the list into a string
	 * @return one-line string of the list's contents
	 */
	public String toString() {
		String result = "";
		if (head != null) {
			LLNode<T> ptr = head;
			while (ptr != null) {
				result += (ptr.getData() + ",");
				ptr = ptr.next;
			}
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
}
