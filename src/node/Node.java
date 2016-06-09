package node;

public class Node<T> {
	private T data;
	
	/**
	 * Standard node
	 * @param value
	 */
	public Node(T value) {
		this.data = value;
	}
	
	/**
	 * Gets the node's data
	 * @return
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Sets the data value of the node
	 * @param d
	 */
	public void setData(T d) {
		this.data = d;
	}
}