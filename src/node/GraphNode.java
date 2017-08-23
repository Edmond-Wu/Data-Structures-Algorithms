package node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Edmond Wu on 9/12/2016.
 */
public class GraphNode<T> extends Node<T> {

    private Set<GraphEdge<T>> edges;

    /**
     * Node for a graph
     * @param value data
     */
    public GraphNode(T value) {
        super(value);
        edges = new HashSet<>();
    }

    /**
     * Returns the node's list of edges
     * @return hashset of node's edges
     */
    public Set<GraphEdge<T>> getEdges() {
        return edges;
    }
    
    /**
     * Adds an edge to the node's set of edges
     * @param node
     * @param weight (this should be a positive value)
     */
    public void addEdge(GraphNode<T> node, double weight) {
    	if (weight > 0) {
    		edges.add(new GraphEdge<T>(this, node, weight));
    	}
    }
}
