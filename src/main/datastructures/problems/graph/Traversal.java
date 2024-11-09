package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class Traversal {
	
	public static <T> List<T> depthFirst(Graph<T> graph) {
		Map<Vertex<T>, Boolean> visited = new HashMap<>();
		visited.put(graph.root, false);
		return depthFirstUtil(graph.root, visited, new ArrayList<>());
	}
	
	private static <T> List<T> depthFirstUtil(Vertex<T> vertex, Map<Vertex<T>, Boolean> visited, List<T> result) {
		if (vertex == null) return result;
		
		result.add(vertex.label);
		visited.put(vertex,  true);
		
		List<Vertex<T>> adjacents = vertex.adjacencyList;
		for (Vertex<T> adjacent : adjacents) {
			if (!visited.getOrDefault(adjacent, false))
				depthFirstUtil(adjacent, visited, result);
		}
		return result;
	}

}
