public class LinkedList {
	Node head;
	
	public void append(int data) {
		Node last = null;
		Node node = this.head;
		if (this.head == null) {
			this.head = new Node(data);
			return;
		}
		
		while (node != null) {
			last = node;
			node = node.next;
		}
		last.next = new Node(data);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		Node node = this.head;
		while (node != null) {
			sb.append(node.data + " ");
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
