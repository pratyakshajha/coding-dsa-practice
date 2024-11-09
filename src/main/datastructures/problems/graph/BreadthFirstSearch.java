package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

@SuppressWarnings("rawtypes")

public class BreadthFirstSearch {
	public void breadthFirstSearch(Vertex s, Graph graph, Map<Vertex , Boolean> visited, Vertex key) {
		Queue<Vertex> queue = new LinkedList<>();
		List<Vertex> lst = new ArrayList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Vertex v = queue.remove();
			if (!visited.get(v)) {
				visited.put(v,  true);
				lst.add(v);
			}
			for (Vertex r: graph.adjacencyList.get(v)) {
				if (!visited.get(r)) {
					queue.add(r);
				}
			}
		}
		for (Vertex temp : lst) {
			System.out.println(temp.label);
			if (temp.label == key.label) {
				break;
			}
		}
	}
}
