package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class BreadthFirstSearch<T> {
	public void breadthFirstSearch(Vertex<T> s, Graph<T> graph, Map<Vertex<T> , Boolean> visited, Vertex<T> key) {
		Queue<Vertex<T>> queue = new LinkedList<>();
		List<Vertex<T>> lst = new ArrayList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Vertex<T> v = queue.remove();
			if (!visited.get(v)) {
				visited.put(v,  true);
				lst.add(v);
			}
			for (Vertex<T> r: graph.adjacencyList.get(v)) {
				if (!visited.get(r)) {
					queue.add(r);
				}
			}
		}
		for (Vertex<T> temp : lst) {
			if (temp.label == key.label) {
				break;
			}
		}
	}
}
