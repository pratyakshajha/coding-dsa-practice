package datastructures.problems.binarytree;
import datastructures.tree.TreeNode;

public class PostOrderTraversal{
	public void postOrderTraversal (TreeNode node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.data);
	}
}
