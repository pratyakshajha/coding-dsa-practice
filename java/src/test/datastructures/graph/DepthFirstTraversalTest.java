package datastructures.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import datastructures.problems.graph.DepthFirstTraversal;

public class DepthFirstTraversalTest {
	
	
	@Test
	public void testSimple() {
		/*
		 *  		A
		 *    	 /  |  \
		 *      B - C   D
		 *      	|
		 *      	E
		 */
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("B", "C");
		graph.addEdge("C", "E");
		System.out.println(graph.adjacencyList);
		Map <Vertex, Boolean> visited = populateVisited(graph);
		DepthFirstTraversal dfs = new DepthFirstTraversal();
		Vertex<String> a = new Vertex<>("A");
		dfs.depthFirstTraversal(a, graph ,visited);
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
