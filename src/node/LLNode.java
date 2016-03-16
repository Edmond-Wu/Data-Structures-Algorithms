package node;

public class LLNode<T> extends Node<T> {
	
	public LLNode<T> next;
	
	public LLNode(T value) {
		super(value);
		next = null;
	}
}
