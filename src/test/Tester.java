package test;

import structures.Graph;
import structures.LinkedList;
import structures.Queue;
import structures.Stack;
import structures.Tree;
import node.GraphNode;
import sort.MergeSort;

public class Tester {
	public static void main(String[] args) {
		//Queue testing
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 1; i <= 10; i++) {
			q.enqueue(i);
		}
		System.out.println("Size of queue: " + q.getSize());
		System.out.println("Head is: " + q.getHead());
		System.out.println("Tail is: " + q.getTail());
		System.out.println(q.toString());
		q.dequeue();
		System.out.println(q.toString() + "\n");

		//Linked List testing
		LinkedList<Character> l = new LinkedList<Character>();
		String word = "eternalenvy";
		for (int j = 0; j < word.length(); j++) {
			l.addToBack(word.charAt(j));
		}
		System.out.println(l.toString());
		l.removeHead();
		l.addToFront('E');
		l.removeTail();
		System.out.println(l.toString());
		l.reverse();
		System.out.println(l.toString());
		System.out.println("Linked List size: " + l.getSize() + "\n");
		
		//Stack testing
		Stack<Integer> stk = new Stack<Integer>();
		for (int x = 1; x <= 10; x++) {
			stk.push(x);
		}
		System.out.println("Stack size: " + stk.getSize());
		
		while (!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}

		//Tree testing
		Tree tree = new Tree();
		int[] arr = {5, 1, 7, 3, 6, 10, 4, 20, 15, 2};
		for (int y = 0; y < arr.length; y++) {
			tree.addNode(arr[y]);
		}
		System.out.println("\n\n" + tree.findTarget(tree.getRoot(), 11));
		System.out.println(tree.deleteNode(4));
		System.out.println();
		tree.inOrderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("Depth of tree: " + tree.getDepth(tree.getRoot()) + "\n");

		//Merge sort testing
		int array[] = {22,21,19,18,15,14,9,7,5};
		System.out.println(MergeSort.arrayString(MergeSort.sort(array)));
		System.out.println();
		
		//Graph testing
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
