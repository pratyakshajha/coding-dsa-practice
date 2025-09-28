package datastructures.problems.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import datastructures.tree.BinaryTree;

public class HeightOfTreeTest {

	@Test
	public void testHeightSimpleTree() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		HeightOfTree ht = new HeightOfTree();
		assertEquals(3, ht.height(tree.root));
	}
	
	@Test
	public void testHeightEmptyTree() {
		BinaryTree tree = BinaryTreeUtility.getEmptyTree();
		HeightOfTree ht = new HeightOfTree();
		assertEquals(0, ht.height(tree.root));
	}
	
	@Test
	public void testHeightWithRootOnly() {
		BinaryTree tree = BinaryTreeUtility.getTreeWithRootOnly();
		HeightOfTree ht = new HeightOfTree();
		assertEquals(1, ht.height(tree.root));
	}
	
	@Test
	public void testHeightBalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getBalancedTree();
		HeightOfTree ht = new HeightOfTree();
		assertEquals(4, ht.height(tree.root));
	}
	
	@Test
	public void testHeightUnbalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getUnbalancedTree();
		HeightOfTree ht = new HeightOfTree();
		assertEquals(5, ht.height(tree.root));
	}
}