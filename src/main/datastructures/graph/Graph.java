package datastructures.graph;

public class Graph<T> {
	public Vertex<T> root;
	int[][] adjacencyMatrix;

	public Graph() {
		this.root = null;
	}
	
	public Graph(Vertex<T> root) {
		this.root = root;
	}
	
	public Graph(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

}
