package datastructures.problems.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class SearchTest {
	
	@Test
	public void testSimple() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		assertTrue(Search.depthFirst(graph, new Vertex<>("C")));
	}
	
	@Test
	public void testSimpleNumeric() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		assertTrue(Search.depthFirst(graph, new Vertex<>(3)));
	}
	
	@Test
	public void testSimple404() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		assertFalse(Search.depthFirst(graph, new Vertex<>("Z")));
	}
	
	@Test
	public void testSimpleNumeric404() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		assertFalse(Search.depthFirst(graph, new Vertex<>(458)));
	}

}
