package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;
@SuppressWarnings("rawtypes")

public class DepthFirstSearch {
	public void helper(Vertex s, Graph graph, Map<Vertex , Boolean> visited, List<Vertex> lst) {
		
		if (s == null) return;
		if (!visited.get(s)) {
			// visit
			lst.add(s);
			visited.put(s, true);
			List<Vertex> adjacents = graph.adjacencyList.get(s);
			for (Vertex v : adjacents) {
				if (!visited.get(v))
				helper(v, graph, visited, lst);
			}
		}
	}
	
	public void depthFirstSearch(Vertex s, Graph graph, Map<Vertex , Boolean> visited, Vertex key) {
		List<Vertex> lst = new ArrayList<>();
		helper (s, graph, visited, lst);
		for (Vertex temp : lst) {
			System.out.println(temp.label);
			if (temp.label == key.label) {
				break;
			}
		}
	}
}
