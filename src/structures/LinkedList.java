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
	 * Checks if the linked list is empty
	 * @return true if size is 0, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
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
			LLNode<T> newHead = new LLNode<T>(data);
			newHead.setNext(head);
			head = newHead;
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
			while (ptr.getNext() != null) {
				ptr = ptr.getNext();
			}
			ptr.setNext(added);
			tail = ptr.getNext();
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
			if (head.getNext() == null) {
				head = null;
				tail = null;
			}
			else {
				head = head.getNext();
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
			while (ptr.getNext() != tail) {
				ptr = ptr.getNext();
			}
			ptr.setNext(null);
			tail = ptr;
			size--;
			return data;
		}
	}

	/**
	 * Reverses the linked list
	 */
	public void reverse() {
		if (head == null || head.getNext() == null) {
			return;
		}
		LLNode<T> before = null;
		LLNode<T> tmp = head;
		while (tmp != null) {
			LLNode<T> next = tmp.getNext(); //make copy of the next node

			//change pointers
			tmp.setNext(before);
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
	        newHead = new LLNode<Integer>(headA.getData());
	        headA = headA.getNext();
	    }
	    else {
	        newHead = new LLNode<Integer>(headB.getData());
	        headB = headB.getNext();
	    }
	    newPtr = newHead;
	    LLNode<Integer> ptrA = headA, ptrB = headB;
	    //iterate through each list and add to the new list
	    while (ptrA != null && ptrB != null) {
	        if (ptrA.getData() < ptrB.getData()) {
	        	newPtr.setNext(new LLNode<Integer>(ptrA.getData()));
	            ptrA = ptrA.getNext();
	        }
	        else {
	            newPtr.setNext(new LLNode<Integer>(ptrB.getData()));
	            ptrB = ptrB.getNext();
	        }
	        newPtr = newPtr.getNext();
	    }
	    if (ptrA == null) {
	    	newPtr.setNext(ptrB);
	    }
	    else {
	    	newPtr.setNext(ptrA);
	    }
	    return newHead;
	}
	
	/**
	 * Gets the string form of a list from any given node
	 * @param node
	 * @return contents of the list starting from the node
	 */
	public static<T> String getStringFromNode(LLNode<T> node) {
		StringBuilder builder = new StringBuilder();
		if (node == null) {
			return "";
		}
		LLNode<T> ptr = node;
		while (ptr != null) {
			builder.append(ptr.getData() + " ");
			ptr = ptr.getNext();
		}
		return builder.toString();
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
				ptr = ptr.getNext();
			}
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
}
