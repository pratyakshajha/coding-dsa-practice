package datastructures.problems.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import datastructures.graph.Graph;

public class TraversalTest {
	
	@Test
	public void testSimpleDfs() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		List<String> expected = List.of("A", "B", "C", "E", "D");
		assertEquals(expected, Traversal.depthFirst(graph));
	}
	
	@Test
	public void testSimpleNumericDfs() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
		assertEquals(expected, Traversal.depthFirst(graph));
	}
	
	@Test
	public void testSimpleBfs() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		List<String> expected = List.of("A", "B", "C", "D", "E");
		assertEquals(expected, Traversal.breadthFirst(graph));
	}
	
	@Test
	public void testSimpleNumericBfs() {
		Graph<Integer> graph = GraphUtility.getSimpleNumericGraph();
		List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
		assertEquals(expected, Traversal.breadthFirst(graph));
	}

}
