package datastructures.problems.binarytree;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

public class BinaryTreeUtility {
	
	public static BinaryTree getSimpleTree() {
		/*
			 	 9
			 	/ \
			   5  16
			  / \   \
			 3  7   18
		*/
		BinaryTree bt = new BinaryTree(new TreeNode (9));
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(16);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(7);
		bt.root.right.right = new TreeNode(18);
		return bt;
	}
	
	public static BinaryTree getEmptyTree() {
		return new BinaryTree(null);
	}
	
	public static BinaryTree getTreeWithRootOnly() {
		return new BinaryTree(new TreeNode (9));
	}
	
	public static BinaryTree getUnbalancedTree() {
		/*
			 	 9
			 	/ \
			   3  16
			    \   
			    7
			   /
			  6
			 /
			4   
		*/
		BinaryTree bt = new BinaryTree(new TreeNode (9));
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(16);
		bt.root.left.right = new TreeNode(7);
		bt.root.left.right.left = new TreeNode(6);
		bt.root.left.right.left.left = new TreeNode(4);
		return bt;
	}
	
	public static BinaryTree getBalancedTree() {
		/*
			 	       9
			 	 /           \
			    3            16
			  /   \        /    \
			 2     7      15    25
			/ \   / \    / \    / \
		   1   6 5   8  12 20  22 28 
		*/
		BinaryTree bt = new BinaryTree(new TreeNode (9));
		// left subtree
		bt.root.left = new TreeNode(3);
		
		bt.root.left.left = new TreeNode(2);
		bt.root.left.right = new TreeNode(7);
		
		bt.root.left.left.left = new TreeNode(1);
		bt.root.left.left.right = new TreeNode(6);
		bt.root.left.right.left = new TreeNode(5);
		bt.root.left.right.right = new TreeNode(8);
		
		// right subtree
		bt.root.right = new TreeNode(16);
		
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(25);
		
		bt.root.right.left.left = new TreeNode(12);
		bt.root.right.left.right = new TreeNode(20);
		bt.root.right.right.left = new TreeNode(22);
		bt.root.right.right.right = new TreeNode(28);
		
		return bt;
	}
}
