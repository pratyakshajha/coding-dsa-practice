package datastructures.problems.graph;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;

public class GraphUtility {
	
	public static Graph<String> getSimpleGraph() {
		/*
		 *  		A
		 *    	 /  |  \
		 *      B - C   D
		 *      	|
		 *      	E
		 */
		Vertex<String> vA = new Vertex<>("A");
		Vertex<String> vB = new Vertex<>("B");
		Vertex<String> vC = new Vertex<>("C");
		Vertex<String> vD = new Vertex<>("D");
		Vertex<String> vE = new Vertex<>("E");
		vA.addEdge(vB);
		vA.addEdge(vC);
		vA.addEdge(vD);
		vB.addEdge(vC);
		vC.addEdge(vE);
		return new Graph<>(vA);
	}
	
	public static Graph<Integer> getSimpleNumericGraph() {
		/*
		 *  		1
		 *    	 /  |  \
		 *      2   3   4
		 *      	  /   \
		 *      	 5     6
		 */
		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		Vertex<Integer> v3 = new Vertex<>(3);
		Vertex<Integer> v4 = new Vertex<>(4);
		Vertex<Integer> v5 = new Vertex<>(5);
		Vertex<Integer> v6 = new Vertex<>(6);
		v1.addEdge(v2);
		v1.addEdge(v3);
		v1.addEdge(v4);
		v4.addEdge(v5);
		v4.addEdge(v6);
		return new Graph<>(v1);
	}
	
	public static Graph<String> getEmptyGraph() {
		return new Graph<>(null);
	}
	
	public static Graph<Integer> getGraphWithRootOnly() {
		return new Graph<>(new Vertex<> (9));
	}
	
}
