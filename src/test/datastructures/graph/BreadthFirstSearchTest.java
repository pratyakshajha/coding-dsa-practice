package datastructures.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import datastructures.problems.graph.BreadthFirstSearch;

@SuppressWarnings("rawtypes")
public class BreadthFirstSearchTest {
	
	
	@Test
	public void testSimple() {
		/*
		 *  		A
		 *    	 /  |  \
		 *      B - C   D
		 *      	|	|
		 *      	E - F
		 *      	|
		 *      	G
		 */
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("B", "C");
		graph.addEdge("C", "E");
		graph.addEdge("E", "G");
		graph.addEdge("D", "F");
		graph.addEdge("F", "E");
		System.out.println(graph.adjacencyList);
		Map <Vertex, Boolean> visited = populateVisited(graph);
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		Vertex<String> a = new Vertex<>("A");
		Vertex <String> d = new Vertex<>("D");
		bfs.breadthFirstSearch(a, graph ,visited, d);
	}
	
	public static Map<Vertex, Boolean> populateVisited(Graph graph) {
		Set<Vertex> vertices = graph.adjacencyList.keySet();
		Map<Vertex, Boolean> visited = new HashMap<>();
		for (Vertex v : vertices) {
			visited.put(v, false);
		}
		return visited;
	}
}
