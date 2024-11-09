package datastructures.graph;

import java.util.Objects;

public class Vertex<T>{
	public T label;
	public Vertex (T label) {
		this.label = label;
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
		Vertex other = (Vertex) obj;
		return Objects.equals(label, other.label);
	}
	@Override
	public String toString() {
		return "Vertex [label=" + label + "]";
	} 
}
