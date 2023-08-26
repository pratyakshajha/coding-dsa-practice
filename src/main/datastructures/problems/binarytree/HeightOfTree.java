package datastructures.problems.binarytree;

import datastructures.tree.TreeNode;

public class HeightOfTree {
	public int height(TreeNode node) {
		if (node == null)
			return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
}