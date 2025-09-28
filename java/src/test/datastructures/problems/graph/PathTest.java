package datastructures.problems.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class PathTest {

	@Test
	public void testSimpleFindPath() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		Vertex<String> vA = graph.root;
		Vertex<String> vB = vA.adjacencyList.get(0);
		Vertex<String> vC = vA.adjacencyList.get(1);
		Vertex<String> vD = vA.adjacencyList.get(2);
		Vertex<String> vE = vC.adjacencyList.get(2);
		assertEquals(List.of("A", "B"), Path.findPathsDfs(vA, vB));
		assertEquals(List.of("A", "B", "C"), Path.findPathsDfs(vA, vC));
		assertEquals(List.of("A", "D"), Path.findPathsDfs(vA, vD));
		assertEquals(List.of("A", "B", "C", "E"), Path.findPathsDfs(vA, vE));
		assertEquals(List.of("D", "A", "B", "C", "E"), Path.findPathsDfs(vD, vE));
		assertEquals(List.of(), Path.findPathsDfs(vD, new Vertex<>("F")));
	}

	@Test
	public void testSimpleBfsPath() {
		Graph<String> graph = GraphUtility.getSimpleGraph();
		Vertex<String> vA = graph.root;
		Vertex<String> vB = vA.adjacencyList.get(0);
		Vertex<String> vC = vA.adjacencyList.get(1);
		Vertex<String> vD = vA.adjacencyList.get(2);
		Vertex<String> vE = vC.adjacencyList.get(2);

		assertEquals(List.of("A", "B"), Path.findPathsBfs(vA, vB));
		assertEquals(List.of("A", "C"), Path.findPathsBfs(vA, vC));
		assertEquals(List.of("A", "D"), Path.findPathsBfs(vA, vD));
		assertEquals(List.of("A", "C", "E"), Path.findPathsBfs(vA, vE));
		assertEquals(List.of("D", "A", "C", "E"), Path.findPathsBfs(vD, vE));
		assertEquals(List.of(), Path.findPathsBfs(vD, new Vertex<>("F")));
	}
	
	@Test
	public void testSimpleShortestPath() {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		assertArrayEquals(
				new int[] {0, 4, 12, 19, 21, 11, 9, 8, 14},
				Path.shortestDistanceFromSource(graph, 0)
				);
		
	}

}
