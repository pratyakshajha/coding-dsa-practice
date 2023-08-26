package datastructures.tree;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public String toString() {
		return String.valueOf(this.data);
	}
}
