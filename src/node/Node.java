package node;

public class Node<T> {
	private T data;
	
	public Node(T value) {
		this.data = value;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T d) {
		this.data = d;
	}
}