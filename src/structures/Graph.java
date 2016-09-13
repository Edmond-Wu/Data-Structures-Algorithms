package structures;

import node.GraphNode;
import java.util.*;

/**
 * Created by edma_ on 9/12/2016.
 */
public class Graph<T> {
    private HashSet<GraphNode<T>> nodes;

    /**
     * Constructor for a graph
     */
    public Graph() {
        nodes = new HashSet<>();
    }

    /**
     * Retrieve list of nodes
     * @return nodes
     */
    public HashSet<GraphNode<T>> getNodes() {
        return nodes;
    }

    /**
     * Performs a breadth-first-search (bfs) traversal of the graph
     * @param start starting node
     */
    public void bfs(GraphNode start) {
        if (start == null) {
            return;
        }
        Queue<GraphNode<T>> queue = new Queue<>();
        HashSet<GraphNode<T>> visited = new HashSet<>();
        queue.enqueue(start);
        System.out.println(start.getData());
        visited.add(start);
        while (queue.getSize() != 0) {
            GraphNode<T> node = queue.dequeue();
            for (GraphNode<T> neighbor : node.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    System.out.println(neighbor.getData());
                    visited.add(neighbor);
                    queue.enqueue(neighbor);
                }
            }
        }
    }
}
