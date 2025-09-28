package datastructures.problems.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class BreadthFirstTraversal<T> {
	public void breadthFirstTraversal(Vertex<T> s, Graph<T> graph, Map<Vertex<T> , Boolean> visited) {
		Queue<Vertex<T>> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Vertex<T> v = queue.remove();
			if (!visited.get(v)) {
				visited.put(v,  true);
				System.out.println(v.label);
			}
			for (Vertex<T> r: graph.adjacencyList.get(v)) {
				if (!visited.get(r)) {
					queue.add(r);
				}
			}
		}
	}
}
