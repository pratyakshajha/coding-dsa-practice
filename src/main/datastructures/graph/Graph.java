package datastructures.graph;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	public Vertex<T> root;
	public Map<Vertex<T>, List<Vertex<T>>> adjacencyList = new HashMap<>();
	public List<List<Integer>> adjacencyMatrix;

	public Graph() {
		this.root = null;
	}
	
	public Graph(Vertex<T> root) {
		this.root = root;
	}
	
	public Graph(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
	
	public void addVertex(String label) {
		Vertex v = new Vertex<>(label);
		if (adjacencyList.get(v) == null) {
			adjacencyList.put(v, new ArrayList<>());
		}
	}
	
	public void removeVertex(String label) {
		Vertex v = new Vertex<>(label);
		if (adjacencyList.get(v) != null) {
			adjacencyList.remove(v);
		}
	}
	
	public void addEdge(String label1, String label2) {
		Vertex v1 = new Vertex<>(label1);
		Vertex v2 = new Vertex<>(label2);
		if (adjacencyList.get(v1) != null)
			adjacencyList.get(v1).add(v2);
		if (adjacencyList.get(v2) != null)
			adjacencyList.get(v2).add(v1);
	}
	
	public void removeEdge(String label1, String label2) {
		Vertex v1 = new Vertex<>(label1);
		Vertex v2 = new Vertex<>(label2);
		if (adjacencyList.get(v1) != null)
			adjacencyList.get(v1).remove(v2);
		if (adjacencyList.get(v2) != null)
			adjacencyList.get(v2).remove(v1);
	}
	
	public List<Vertex> adjVertice (String label) {
		return adjacencyList.get(new Vertex<>(label));
	}
}
