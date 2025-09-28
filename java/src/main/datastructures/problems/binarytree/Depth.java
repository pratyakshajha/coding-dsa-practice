package datastructures.problems.binarytree;

import datastructures.tree.TreeNode;

public class Depth {
	public int depth(TreeNode node, TreeNode key) {
		if (node == null) return -1;
		int distance = -1;
		if (node.data == key.data) 
			distance =  distance+1;
		int leftDepth = depth(node.left, key);
		int rightDepth= depth(node.right, key);
		if (leftDepth >= 0) {
			distance =  leftDepth + 1;
		}
		if (rightDepth >= 0) {
			distance = rightDepth + 1;
		}
		return distance;
	}
}
