package datastructures.problems.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class Search {
	
	public static <T> boolean depthFirst(Graph<T> graph, Vertex<T> key) {
		Map<Vertex<T>, Boolean> visited = new HashMap<>();
		visited.put(graph.root, false);
		return depthFirstUtil(graph.root, visited, key);
	}
	
	private static <T> boolean depthFirstUtil(Vertex<T> vertex, Map<Vertex<T>, Boolean> visited, Vertex<T> key) {
		if (vertex == null) return false;
		
		if (vertex.equals(key))
			return true;
		visited.put(vertex, true);
		
		List<Vertex<T>> adjacents = vertex.adjacencyList;
		for (Vertex<T> adjacent : adjacents) {
			if (!visited.getOrDefault(adjacent, false))
				if (depthFirstUtil(adjacent, visited, key))
					return true;
		}
		return false;
	}

}
