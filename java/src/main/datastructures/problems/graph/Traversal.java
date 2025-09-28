package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class Traversal {

	public static <T> List<T> depthFirst(Graph<T> graph) {
		return depthFirstUtil(graph.root, new HashSet<>(), new ArrayList<>());
	}

	private static <T> List<T> depthFirstUtil(Vertex<T> vertex, Set<Vertex<T>> visited, List<T> result) {
		if (vertex == null)
			return result;

		result.add(vertex.label);
		visited.add(vertex);

		for (Vertex<T> adjacent : vertex.adjacencyList) {
			if (!visited.contains(adjacent)) {
				depthFirstUtil(adjacent, visited, result);
				visited.add(adjacent);
			}
		}
		return result;
	}

	public static <T> List<T> breadthFirst(Graph<T> graph) {
		List<T> visited = new ArrayList<>();
		Queue<Vertex<T>> toVisit = new LinkedList<>();

		toVisit.add(graph.root);
		visited.add(graph.root.label);

		while (!toVisit.isEmpty()) {
			Vertex<T> current = toVisit.remove();

			for (Vertex<T> adjacent : current.adjacencyList) {
				if (!visited.contains(adjacent.label)) {
					toVisit.add(adjacent);
					visited.add(adjacent.label);
				}
			}
		}
		return visited;
	}

}
