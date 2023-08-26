package datastructures.problems.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import datastructures.tree.BinaryTree;

public class LevelOrderTraversalTest {
	@Test
	public void testLotSimpleTree() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = Arrays.asList(9, 5, 16, 3, 7, 18);
		assertEquals(expected, lot.levelOrderTraversal(tree.root));
	}
	
	@Test
	public void testLotEmptyTree() {
		BinaryTree tree = BinaryTreeUtility.getEmptyTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		assertEquals(new ArrayList<>(), lot.levelOrderTraversal(tree.root));
	}
	
	@Test
	public void testLotWithRootOnly() {
		BinaryTree tree = BinaryTreeUtility.getTreeWithRootOnly();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		assertEquals(Arrays.asList(9), lot.levelOrderTraversal(tree.root));
	}
	
	@Test
	public void testLotBalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getBalancedTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = Arrays.asList(9, 3, 16, 2, 7, 15, 25, 1, 6, 5, 8, 12, 20, 22, 28);
		assertEquals(expected, lot.levelOrderTraversal(tree.root));
	}
	
	@Test
	public void testLotUnbalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getUnbalancedTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = Arrays.asList(9, 3, 16, 7, 6, 4);
		assertEquals(expected, lot.levelOrderTraversal(tree.root));
	}
}
