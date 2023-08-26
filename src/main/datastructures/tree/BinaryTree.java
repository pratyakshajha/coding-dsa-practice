package datastructures.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	public TreeNode root;
	
	public BinaryTree (TreeNode root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		/*
		 	 9
		 	/ \
		   5  16
		  / \   \
		  3  7  18
		 */
		TreeNode n1 = new TreeNode (9);
		BinaryTree bin = new BinaryTree(n1);
		bin.root.left = new TreeNode(5);
		bin.root.right = new TreeNode(16);
		bin.root.left.left = new TreeNode(3);
		bin.root.left.right = new TreeNode(7);
		bin.root.right.right = new TreeNode(18);

		
//		bin.preOrderTraversal(bin.root);
//		bin.postOrderTraversal(bin.root);
//		bin.inOrderTraversal(bin.root);
//		bin.levelOrder(bin.root);
//		System.out.println(bin.LCA(n1,  bin.root.left, bin.root.right));
//		System.out.println(bin.height(bin.root));
//		System.out.println(bin.depth(bin.root, bin.root.right));
//		bin.zigZagOrder(bin.root);
//		System.out.println(bin.isPerfectlyBalanced(bin.root));
//		System.out.println(bin.isBalanced(bin.root));
		bin.boundaryTraversal(bin.root);
	}
	
	// 9 5 3 7 16 18
	public void preOrderTraversal (TreeNode n) {
		if (n == null) {
			return;
		}
		System.out.println(n.data);
		preOrderTraversal(n.left);
		preOrderTraversal(n.right);
	}
	
	public void preOrder (TreeNode n) {
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) System.out.println(n.data);
		preOrder(n.left);
		preOrder(n.right);
	}
	
	//3 7 5 18 16 9
	public void postOrderTraversal (TreeNode node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.data);
	}
	
	// 3 5 7 9 16 18
	public void inOrderTraversal (TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}
	
	//9 5 16 3 7 18
	public void levelOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		Queue<TreeNode> toVisit = new LinkedList<>();
		toVisit.add(node);
		while (!toVisit.isEmpty()) {
			TreeNode current = toVisit.remove();
			System.out.println(current);
			if (current.left != null) {
				toVisit.add(current.left);
			}
			if (current.right != null) {
				toVisit.add(current.right);
			}
		}
	}
	
	//Least Common Ancestor
	public boolean exists (TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (p == root) {
			return true;
		}
		return exists(root.left, p) ||exists(root.right, p);
	}
	
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || !exists(root, p) || !exists(root, q)) {
			return null;
		}
		if (p == root || q == root) {
			return root;
		}
		return Helper(root, p, q);
	}
	public TreeNode Helper(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode child = new TreeNode(root.data);
		boolean a = exists(root.left, p);
		boolean b = exists(root.left, q);
		if ( a != b) {
			return root;
		}
		if (a) {
			child = root.left;
		}
		else {
			child = root.right;
		}
		return Helper(child,p,q);
	}
	//LCA end
	
	//Height of a tree
	public int height(TreeNode node) {
		if (node == null) return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		if (leftHeight>rightHeight) {
			return leftHeight+1;
		}
		else {
			return rightHeight+1;
		}
	}
	
	//Depth of a tree
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
	
	//Zigzag traversal of a tree
	public void zigZagOrder(TreeNode node) {
		List<TreeNode> res = new ArrayList<>();
		if (node == null) {
			return;
		}
		int index;
		Queue<TreeNode> toVisit = new LinkedList<>();
		toVisit.add(node);
		boolean leftToRight = true;
		while (!toVisit.isEmpty()) {
			int size = toVisit.size();
			TreeNode[] row = new TreeNode[size];
			Arrays.fill(row, 0);
			for (int i = 0; i<size; i++) {
				index = leftToRight?i:(size-1-i);
				node = toVisit.remove();
				row[index] =  node;
				if (node.left != null) {
					toVisit.add(node.left);
				}
				if (node.right != null) {
					toVisit.add(node.right);
				}
				for (int j = 0; j<row.length; j++) {
					res.add(row[j]);
				}
			}
			leftToRight = !leftToRight;
			for (int j = 0; j<res.size(); j++)
				System.out.println(res.get(j));
		}
	}
	
	//Check whether a tree is perfectly balanced or not
	public boolean isPerfectlyBalanced(TreeNode node) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) return true;
		else if (node.left == null && node.right != null) return false;
		else if (node.right == null && node.left != null) return false;
		else return (isPerfectlyBalanced(node.left) && isPerfectlyBalanced(node.right));
	}
	//Check whether a tree is balanced or not
	int checkHeight (TreeNode node) {
		if (node == null) return -1;
		int leftHeight = checkHeight(node.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = checkHeight(node.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		}
		else {
			return Math.max(leftHeight, rightHeight) +1;
		}
	}
	public boolean isBalanced(TreeNode node) {
		return checkHeight(node) != Integer.MIN_VALUE;
	}
	
	//Boundary Traversal
	// 9 5 3 7 18 16
	public void boundaryTraversal(TreeNode node) {
		left(node);
		right(node);
	}
	
	public void left(TreeNode node) {
		Queue<TreeNode> left = new LinkedList<>();
		while (node != null) {
			if (!isLeaf(node)) {
				left.add(node);
			}
			if (node.left != null) {
				node = node.left;
			}
			else {
				node = node.right;
			}
		}
		while (!left.isEmpty()) {
			System.out.println(left.remove());
		}
			preOrder(root);
	}
	
	public void right(TreeNode node) {
		Stack<TreeNode> right = new Stack<>();
		while (node != null) {
			if (!isLeaf(node) && node != root) {
				right.push(node);
			}
			if (node.right != null) {
				node = node.right;
			}
			else {
				node = node.left;
			}
		}
		while (!right.isEmpty()) {
			System.out.println(right.pop());
		}
	}
	
	public boolean isLeaf(TreeNode node) {
		if (node.left == null && node.right == null) return true;
		else return false;
	}
}

class Node {
	int data;
	TreeNode left;
	TreeNode right;
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public String toString() {
		return String.valueOf(this.data);
	}
}