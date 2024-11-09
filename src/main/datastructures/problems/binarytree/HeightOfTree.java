package datastructures.problems.binarytree;

import datastructures.tree.TreeNode;

public class HeightOfTree {

	public int height(TreeNode node) {
		if (node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
}