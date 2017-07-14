package node;

public class LLNode<T> extends Node<T> {
	
	private LLNode<T> next;
	
	/**
	 * A node designed for a linked list implementation
	 * @param value
	 */
	public LLNode(T value) {
		super(value);
		next = null;
	}
	
	/**
	 * Gets the next node
	 * @return
	 */
	public LLNode<T> getNext() {
		return next;
	}
	
	/**
	 * Changes the next node to n
	 * @param node
	 */
	public void setNext(LLNode<T> n) {
		next = n;
	}
}
