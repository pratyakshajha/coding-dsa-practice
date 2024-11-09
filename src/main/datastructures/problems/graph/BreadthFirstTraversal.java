package datastructures.problems.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

@SuppressWarnings("rawtypes")

public class BreadthFirstTraversal {
	public void breadthFirstTraversal(Vertex s, Graph graph, Map<Vertex , Boolean> visited) {
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Vertex v = queue.remove();
			if (!visited.get(v)) {
				visited.put(v,  true);
				System.out.println(v.label);
			}
			for (Vertex r: graph.adjacencyList.get(v)) {
				if (!visited.get(r)) {
					queue.add(r);
				}
			}
		}
	}
}
