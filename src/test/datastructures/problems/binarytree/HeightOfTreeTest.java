package datastructures.problems.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import datastructures.problems.binarytree.HeightOfTree;
import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

public class HeightOfTreeTest {

	@Test
	void testHeightSimple() {
		/*
			 	 9
			 	/ \
			   5  16
			  / \   \
			  3  7  18
		*/
		TreeNode n1 = new TreeNode (9);
		BinaryTree bt = new BinaryTree(n1);
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(16);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(7);
		bt.root.right.right = new TreeNode(18);
		
		HeightOfTree ht = new HeightOfTree();
		assertEquals(3, ht.height(n1));
	}
}