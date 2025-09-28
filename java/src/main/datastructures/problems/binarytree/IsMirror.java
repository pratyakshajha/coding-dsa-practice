package datastructures.problems.binarytree;

import datastructures.tree.TreeNode;

public class IsMirror {
	public boolean isMirror(TreeNode node1, TreeNode node2) {
		boolean flag1 = true;
		boolean flag2 = true;
		if ((node1 != null && node2 == null) || (node1 == null && node2 != null))
			return false;
		if (node1.data != node2.data) {
			return false;
		}
		if (node1.left != null) {
			flag1 = isMirror(node1.left, node2.right);
		}
		if (node1.right != null) {
			flag2 = isMirror(node1.right, node2.left);
		}
		return (flag1 && flag2);
	}
}
