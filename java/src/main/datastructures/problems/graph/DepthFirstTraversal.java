package datastructures.problems.graph;

import java.util.List;
import java.util.Map;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class DepthFirstTraversal<T> {
public void depthFirstTraversal(Vertex<T> s, Graph<T> graph, Map<Vertex<T>, Boolean> visited) {
		
		if (s == null) return;
		if (!visited.get(s)) {
			// visit
			System.out.println(s.label);
			visited.put(s, true);
			List<Vertex<T>> adjacents = graph.adjacencyList.get(s);
			for (Vertex<T> v : adjacents) {
				if (!visited.get(v))
				depthFirstTraversal(v, graph, visited);
			}
		}
	}
}
