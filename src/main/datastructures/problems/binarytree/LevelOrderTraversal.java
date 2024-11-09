package datastructures.problems.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.tree.TreeNode;

// also known as breadth first traversal
public class LevelOrderTraversal {
	
	public List<Integer> levelOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.remove();
			list.add(node.data);

			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
		return list;
	}
	
	public List<Integer> levelOrderTraversalRecursive(TreeNode node) {
		List<Integer> result = new ArrayList<Integer>();
		int height = height(node);
		for (int level = 1; level <= height; level++) {
			result.addAll(traverseLevel(node, level, new ArrayList<>()));
		}
		return result;
	}
	
	private int height(TreeNode node) {
		if (node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	private  List<Integer> traverseLevel(TreeNode node, int level, List<Integer> result) {
		if (node == null) return result;
		if (level == 1) {
			result.add(node.data);
		}
		if (node.left != null) traverseLevel(node.left, level - 1, result);
		if (node.right != null) traverseLevel(node.right, level - 1, result);
		return result;
	}
}
