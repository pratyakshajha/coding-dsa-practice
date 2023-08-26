package datastructures.problems.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.tree.TreeNode;


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
}
