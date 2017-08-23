package test;

import structures.Graph;
import node.GraphNode;

public class Tester {
	public static void main(String[] args) {
		//Graph testing
		System.out.println("Graph testing:");
		Graph<Integer> graph = new Graph<Integer>();
		GraphNode<Integer> a = new GraphNode<Integer>(5);
		GraphNode<Integer> b = new GraphNode<Integer>(10);
		GraphNode<Integer> c = new GraphNode<Integer>(15);
		a.addEdge(b, 1);
		b.addEdge(c, 1);
		c.addEdge(a, 1);
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.bfs(a);
		System.out.println();
		graph.dfs(a);
	}
}
