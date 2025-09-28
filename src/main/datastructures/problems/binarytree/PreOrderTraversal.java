package datastructures.problems.binarytree;

import datastructures.tree.TreeNode;

public class PreOrderTraversal {
	public void preOrderTraversal (TreeNode n) {
		if (n == null) {
			return;
		}
		System.out.println(n.data);
		preOrderTraversal(n.left);
		preOrderTraversal(n.right);
	}
}
