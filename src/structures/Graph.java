package structures;

import node.GraphEdge;
import node.GraphNode;
import java.util.*;

/**
 * Created by Edmond Wu on 9/12/2016.
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
     * Adds a vertex to the graph
     * @param vertex
     */
    public void addVertex(GraphNode<T> vertex) {
    	nodes.add(vertex);
    }

    /**
     * Performs a breadth-first-search (bfs) traversal of the graph
     * @param start starting node
     */
    public void bfs(GraphNode<T> start) {
        if (start == null) {
            return;
        }
        System.out.print("BFS: ");
        Queue<GraphNode<T>> queue = new Queue<>();
        HashSet<GraphNode<T>> visited = new HashSet<>();

        //begin with starting node
        queue.enqueue(start);
        System.out.print(start.getData() + " ");
        visited.add(start);
        while (queue.getSize() != 0) {
            GraphNode<T> node = queue.dequeue();
            for (GraphEdge<T> edge : node.getEdges()) {
                //check if neighbor has been visited
                if (!visited.contains(edge.getEnd())) {
                    System.out.print(edge.getEnd().getData() + " ");
                    visited.add(edge.getEnd());
                    queue.enqueue(edge.getEnd());
                }
            }
        }
    }

    /**
     * Performs a depth-first search (dfs) traversal of the graph
     * @param start starting node
     */
    public void dfs(GraphNode<T> start) {
        if (start == null) {
            return;
        }
        System.out.print("DFS: ");
        HashSet<GraphNode<T>> visited = new HashSet<>();
        Stack<GraphNode<T>> stk = new Stack<>();
        stk.push(start);
        while (!stk.isEmpty()) {
            GraphNode<T> node = stk.pop();
            for (GraphEdge<T> edge : node.getEdges()) {
                if (!visited.contains(edge.getEnd())) {
                    System.out.print(edge.getEnd().getData() + " ");
                    visited.add(edge.getEnd());
                    stk.push(edge.getEnd());          
                }
            }
        }
    }
}
