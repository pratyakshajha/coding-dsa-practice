package datastructures.problems.binarytree;

import datastructures.tree.TreeNode;

public class InOrderTraversal {
	public void inOrderTraversal (TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}
}