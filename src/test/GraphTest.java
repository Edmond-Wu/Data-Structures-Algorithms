package test;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import node.GraphNode;
import structures.Graph;

public class GraphTest extends TestCase {
	private Graph<Integer> graph;
	
	@Before
	public void setUp() {
		graph = new Graph<Integer>();
	}
	
	@Test
	public void testGraph() {
		GraphNode<Integer> a = new GraphNode<Integer>(5);
		GraphNode<Integer> b = new GraphNode<Integer>(10);
		GraphNode<Integer> c = new GraphNode<Integer>(15);
		a.addEdge(b, 1);
		b.addEdge(c, 1);
		c.addEdge(a, 1);
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		assertEquals(graph.getNodes().size(), 3);
		graph.bfs(a);
		System.out.println();
		graph.dfs(a);
	}
}
