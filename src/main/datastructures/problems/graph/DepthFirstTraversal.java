package datastructures.problems.graph;

import java.util.List;
import java.util.Map;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

@SuppressWarnings("rawtypes") 

public class DepthFirstTraversal {
public void depthFirstTraversal(Vertex s, Graph graph, Map<Vertex , Boolean> visited) {
		
		if (s == null) return;
		if (!visited.get(s)) {
			// visit
			System.out.println(s.label);
			visited.put(s, true);
			List<Vertex> adjacents = graph.adjacencyList.get(s);
			for (Vertex v : adjacents) {
				if (!visited.get(v))
				depthFirstTraversal(v, graph, visited);
			}
		}
	}
}
