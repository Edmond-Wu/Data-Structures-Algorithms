package node;

public class LLNode<T> extends Node<T> {
	
	public LLNode<T> next;
	
	/**
	 * A node designed for a linked list implementation
	 * @param value
	 */
	public LLNode(T value) {
		super(value);
		next = null;
	}
}
