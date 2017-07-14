package test;

import structures.Graph;
import structures.LinkedList;
import structures.Queue;
import structures.Stack;
import structures.Tree;
import node.GraphNode;
import sort.MergeSort;
import sort.QuickSort;
import sort.StringArray;

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

		//Linked List testing
		System.out.println("Linked list testing:");
		LinkedList<Character> l = new LinkedList<Character>();
		String word = "eternalenvy";
		for (int j = 0; j < word.length(); j++) {
			l.addToBack(word.charAt(j));
		}
		System.out.println("Linked list: " + l.toString());
		l.removeHead();
		l.addToFront('E');
		l.removeTail();
		System.out.println(l.toString());
		l.reverse();
		System.out.println(l.toString());
		System.out.println("Linked list size: " + l.getSize() );
		int first[] = {1, 3, 5, 6, 8};
		int second[] = {2, 4, 7};
		LinkedList<Integer> firstList = new LinkedList<Integer>();
		LinkedList<Integer> secondList = new LinkedList<Integer>();
		for (int a = 0; a < first.length; a++) {
			firstList.addToBack(first[a]);
		}
		for (int b = 0; b < second.length; b++) {
			secondList.addToBack(second[b]);
		}
		System.out.println("First list: " + firstList.toString());
		System.out.println("Second list: " + secondList.toString());
		System.out.print("Merged: ");
		LinkedList.printList(LinkedList.merge(firstList.getHead(), secondList.getHead()));
		
		//Stack testing
		System.out.println("\nStack testing:");
		Stack<Integer> stk = new Stack<Integer>();
		for (int x = 1; x <= 10; x++) {
			stk.push(x);
		}
		System.out.println("Stack size: " + stk.getSize());
		System.out.print("Stack: ");
		while (!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}

		System.out.println("\n\nTree testing:");
		//Tree testing
		Tree tree = new Tree();
		int[] arr = {5, 1, 7, 3, 6, 10, 4, 20, 15, 2, 9};
		for (int y = 0; y < arr.length; y++) {
			tree.addNode(arr[y]);
		}
		System.out.println("Finding 11: " + tree.findTarget(tree.getRoot(), 11));
		System.out.println("Deleting 4: " + tree.deleteNode(4));
		tree.inOrderTraversal(tree.getRoot());
		System.out.println();
		tree.preOrderTraversal(tree.getRoot());
		System.out.println();
		tree.postOrderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("Depth of tree: " + tree.getDepth(tree.getRoot()) + "\n");

		//Merge sort testing
		System.out.println("Merge sort testing:");
		int array[] = {22, 21, 19, 18, 15, 14, 9, 7, 5};
		System.out.println("Unsorted: " + StringArray.arrayString(array));
		System.out.println("Sorted: " + StringArray.arrayString(MergeSort.sort(array)));
		System.out.println();
		
		//Quick sort testing
		System.out.println("Quick sort testing:");
		int array2[] = {5, 7, 2, 8, 10, 20, 14, 18, 30, 22, 20};
		System.out.println("Unsorted: " + StringArray.arrayString(array2));
		System.out.println("Sorted: " + StringArray.arrayString(QuickSort.sort(array2, 0, array2.length-1)));
		System.out.println();
		
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
