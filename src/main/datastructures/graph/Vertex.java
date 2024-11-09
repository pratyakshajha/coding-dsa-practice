package datastructures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {
	public T label;
	public List<Vertex<T>> adjacencyList = new ArrayList<>();

	public Vertex(T label) {
		this.label = label;
	}
	
	public void addEdge(Vertex<T> v) {
		this.adjacencyList.add(v);
		v.adjacencyList.add(this);
	}

	public void removeEdge(Vertex<T> v) {
		this.adjacencyList.remove(v);
		v.adjacencyList.remove(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex<T> other = (Vertex<T>) obj;
		return Objects.equals(label, other.label);
	}

	@Override
	public String toString() {
		return "Vertex [label=" + label + "]";
	}
}
