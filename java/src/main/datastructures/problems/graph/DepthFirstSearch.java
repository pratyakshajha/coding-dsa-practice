package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class DepthFirstSearch<T> {
	public void helper(Vertex<T> s, Graph<T> graph, Map<Vertex<T> , Boolean> visited, List<Vertex<T>> lst) {
		
		if (s == null) return;
		if (!visited.get(s)) {
			// visit
			lst.add(s);
			visited.put(s, true);
			List<Vertex<T>> adjacents = graph.adjacencyList.get(s);
			for (Vertex<T> v : adjacents) {
				if (!visited.get(v))
				helper(v, graph, visited, lst);
			}
		}
	}
	
	public void depthFirstSearch(Vertex<T> s, Graph<T> graph, Map<Vertex<T>, Boolean> visited, Vertex<T> key) {
		List<Vertex<T>> lst = new ArrayList<>();
		helper (s, graph, visited, lst);
		for (Vertex<T> temp : lst) {
			System.out.println(temp.label);
			if (temp.label == key.label) {
				break;
			}
		}
	}
}
