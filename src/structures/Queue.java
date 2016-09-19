package structures;

//Queue is just a specific linked list in this implementation
public class Queue<T> extends LinkedList<T> {
	
	/**
	 * Default queue constructor, FIFO
	 */
	public Queue () {
		super();
	}
	
	/**
	 * Adds an item to the queue
	 * @param data
	 */
	public void enqueue(T data) {
		super.addToBack(data);
	}

	/**
	 * Peeks the front of the queue without de-queuing
	 * @return data contained in front-most node in queue
	 */
	public T peek() {
		return super.getHead();
	}

	/**
	 * De-queues an item from the queue
	 * @return the de-queued item
	 */
	public T dequeue() {
		return super.removeHead();
	}
}
