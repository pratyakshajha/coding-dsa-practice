package datastructures.graph;

import org.junit.jupiter.api.Test;

public class DepthFirstSearchTest {
	
	@Test
	public void testSimple() {
		/*
		 *  A-B-C
		 *    \ /
		 *     D
		 */
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("B", "D");
		System.out.println(graph.adjacencyList);
	}
}
