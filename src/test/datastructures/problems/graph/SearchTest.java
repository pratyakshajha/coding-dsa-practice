package datastructures.problems.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class SearchTest {
	
	@Test
	public void testSimpleDfs() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		assertTrue(Search.depthFirst(graph, new Vertex<>("C")));
	}
	
	@Test
	public void testSimpleNumericDfs() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		assertTrue(Search.depthFirst(graph, new Vertex<>(3)));
	}
	
	@Test
	public void testSimple404Dfs() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		assertFalse(Search.depthFirst(graph, new Vertex<>("Z")));
	}
	
	@Test
	public void testSimpleNumeric404Dfs() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		assertFalse(Search.depthFirst(graph, new Vertex<>(458)));
	}
	
	@Test
	public void testSimpleBfs() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		assertTrue(Search.breadthFirst(graph, new Vertex<>("C")));
	}
	
	@Test
	public void testSimpleNumericBfs() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		assertTrue(Search.breadthFirst(graph, new Vertex<>(3)));
	}
	
	@Test
	public void testSimple404Bfs() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		assertFalse(Search.breadthFirst(graph, new Vertex<>("Z")));
	}
	
	@Test
	public void testSimpleNumeric404Bfs() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		assertFalse(Search.breadthFirst(graph, new Vertex<>(458)));
	}


}
