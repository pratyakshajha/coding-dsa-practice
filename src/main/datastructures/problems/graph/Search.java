package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class Search {

	public static <T> boolean depthFirst(Graph<T> graph, Vertex<T> key) {
		return depthFirstUtil(graph.root, new HashSet<>(), key);
	}

	private static <T> boolean depthFirstUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Vertex<T> key) {
		if (vertex == null)
			return false;

		if (vertex.equals(key))
			return true;
		visited.add(vertex);

		List<Vertex<T>> adjacents = vertex.adjacencyList;
		for (Vertex<T> adjacent : adjacents) {
			if (!visited.contains(adjacent)) {
				visited.add(adjacent);
				if (depthFirstUtil(adjacent, visited, key))
					return true;
			}
		}
		return false;
	}
	
	public static <T> boolean breadthFirst(Graph<T> graph, Vertex<T> key) {
		List<T> visited = new ArrayList<>();
		Queue<Vertex<T>> toVisit = new LinkedList<>();

		toVisit.add(graph.root);
		visited.add(graph.root.label);

		while (!toVisit.isEmpty()) {
			Vertex<T> current = toVisit.remove();
			if (current.equals(key))
				return true;

			for (Vertex<T> adjacent : current.adjacencyList) {
				if (!visited.contains(adjacent.label)) {
					toVisit.add(adjacent);
					visited.add(adjacent.label);
				}
			}
		}
		return false;
	}

}
