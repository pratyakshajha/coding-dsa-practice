package datastructures.problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import datastructures.graph.Vertex;

public class Path {

	public static <T> List<T> findPathsDfs(Vertex<T> v1, Vertex<T> v2) {
		List<T> path = new ArrayList<>();
		findPathUtil(v1, v2, new HashSet<>(), path);
		return path;
	}

	private static <T> boolean findPathUtil(Vertex<T> v1, Vertex<T> v2, Set<Vertex<T>> visited, List<T> path) {
		visited.add(v1);
		path.add(v1.label);

		if (v1.equals(v2)) {
			return true;
		}

		for (Vertex<T> adjacent : v1.adjacencyList) {
			if (!visited.contains(adjacent)) {
				if (findPathUtil(adjacent, v2, visited, path))
					return true;
			}

		}
		path.remove(path.size() - 1);
		return false;
	}

	// will always find the shortest path
	public static <T> List<T> findPathsBfs(Vertex<T> v1, Vertex<T> v2) {
		Set<Vertex<T>> visited = new HashSet<>();
		Queue<List<Vertex<T>>> toVisit = new LinkedList<>();
		List<Vertex<T>> root = new LinkedList<>();
		root.add(v1);
		toVisit.add(root);
		visited.add(v1);

		while (!toVisit.isEmpty()) {
			List<Vertex<T>> currentPath = toVisit.remove();
			Vertex<T> current = currentPath.get(currentPath.size() - 1);

			for (Vertex<T> adjacent : current.adjacencyList) {
				if (!visited.contains(adjacent)) {
					visited.add(adjacent);
					List<Vertex<T>> newPath = new ArrayList<>(currentPath);
					newPath.add(adjacent);
					toVisit.add(newPath);

					if (adjacent.equals(v2)) {
						// return only the list of labels
						return newPath.stream().map(v -> v.label).toList();
					}
				}
			}

		}
		return new ArrayList<>();
	}

	// dijkstras algorithm
	public static int[] shortestDistanceFromSource(int[][] graph, int source) {
		int size = graph[0].length;
		int[] minDistances = new int[size];
		boolean[] unsettled = new boolean[size];
		for (int i = 0; i < size; i++) {
			minDistances[i] = Integer.MAX_VALUE;
			unsettled[i] = false;
		}

		minDistances[source] = 0;
		for (int count = 0; count < size - 1; count++) {
			int current = getNodeAtMinDistance(minDistances, unsettled);
			unsettled[current] = true;
			for (int i = 0; i < size; i++) {
				int edge = graph[current][i];
				if (!unsettled[i] && edge != 0) {
					int sourceDistance = minDistances[current];
					int nodeDistance = sourceDistance + edge;
					if (nodeDistance < minDistances[i]) {
						minDistances[i] = nodeDistance;
					}
				}
			}
		}
		return minDistances;
	}

	private static int getNodeAtMinDistance(int[] minDistances, boolean[] unsettled) {
		int minimum = Integer.MAX_VALUE;
		int minNode = -1;
		for (int i = 0; i < minDistances.length; i++) {
			if (!unsettled[i] && minDistances[i] <= minimum) {
				minimum = minDistances[i];
				minNode = i;
			}
		}
		return minNode;
	}

}
