package test;

import structures.Graph;
import structures.Queue;
import structures.Stack;
import node.GraphNode;

public class Tester {
	public static void main(String[] args) {
		//Queue testing
		System.out.println("Queue testing:");
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 1; i <= 10; i++) {
			q.enqueue(i);
		}
		System.out.println("Size of queue: " + q.getSize());
		System.out.println("Head is: " + q.getHead().getData());
		System.out.println("Tail is: " + q.getTail().getData());
		System.out.println("Queue: " + q.toString());
		q.dequeue();
		System.out.println("Queue after removing head: " + q.toString() + "\n");
		
		//Stack testing
		System.out.println("Stack testing:");
		Stack<Integer> stk = new Stack<Integer>();
		for (int x = 1; x <= 10; x++) {
			stk.push(x);
		}
		System.out.println("Stack size: " + stk.getSize());
		System.out.print("Stack: ");
		while (!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}
		System.out.println("\n");
		
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
