package node;

public class GraphEdge<T> {
	private GraphNode<T> start, end;
	private double weight;
	
	public GraphEdge(GraphNode<T> a, GraphNode<T> b, double w) {
		start = a;
		end = b;
		weight = w;
	}
	
	public GraphNode<T> getStart() {
		return start;
	}
	
	public GraphNode<T> getEnd() {
		return end;
	}
	
	public double getWeight() {
		return weight;
	}
}
