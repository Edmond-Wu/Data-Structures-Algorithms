package node;

public class GraphEdge<T> {
	private GraphNode<T> start, end;
	private double weight;
	
	/**
	 * Constructor for an edge in a graph
	 * @param a edge starting point
	 * @param b edge ending point
	 * @param w weight of the edge
	 */
	public GraphEdge(GraphNode<T> a, GraphNode<T> b, double w) {
		start = a;
		end = b;
		weight = w;
	}
	
	/**
	 * Gets the starting point of the edge
	 * @return edge starting point
	 */
	public GraphNode<T> getStart() {
		return start;
	}
	
	/**
	 * Gets the ending point of the edge
	 * @return edge end point
	 */
	public GraphNode<T> getEnd() {
		return end;
	}
	
	/**
	 * Gets the weight of the edge
	 * @return weight of the edge as a double
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Change weight of the edge if the new value is positive
	 * @param w new value of the edge
	 */
	public void setWeight(double w) {
		if (w > 0) {
			weight = w;
		}
	}
}
