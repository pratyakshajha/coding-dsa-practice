package datastructures.problems.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import datastructures.tree.BinaryTree;

public class LevelOrderTraversalTest {
	
	@Test
	public void testLotSimpleTree() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = List.of(9, 5, 16, 3, 7, 18);
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
		assertEquals(List.of(9), lot.levelOrderTraversal(tree.root));
	}
	
	@Test
	public void testLotBalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getBalancedTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = List.of(9, 3, 16, 2, 7, 15, 25, 1, 6, 5, 8, 12, 20, 22, 28);
		assertEquals(expected, lot.levelOrderTraversal(tree.root));
	}
	
	@Test
	public void testLotUnbalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getUnbalancedTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = List.of(9, 3, 16, 7, 6, 4);
		assertEquals(expected, lot.levelOrderTraversal(tree.root));
	}
	
	@Test
	public void testLotRecursiveSimpleTree() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = List.of(9, 5, 16, 3, 7, 18);
		assertEquals(expected, lot.levelOrderTraversalRecursive(tree.root));
	}
	
	@Test
	public void testLotRecursiveEmptyTree() {
		BinaryTree tree = BinaryTreeUtility.getEmptyTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		assertEquals(new ArrayList<>(), lot.levelOrderTraversalRecursive(tree.root));
	}
	
	@Test
	public void testLotRecursiveWithRootOnly() {
		BinaryTree tree = BinaryTreeUtility.getTreeWithRootOnly();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		assertEquals(List.of(9), lot.levelOrderTraversalRecursive(tree.root));
	}
	
	@Test
	public void testLotRecursiveBalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getBalancedTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = List.of(9, 3, 16, 2, 7, 15, 25, 1, 6, 5, 8, 12, 20, 22, 28);
		assertEquals(expected, lot.levelOrderTraversalRecursive(tree.root));
	}
	
	@Test
	public void testLotRecursiveUnbalancedTree() {
		BinaryTree tree = BinaryTreeUtility.getUnbalancedTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		List<Integer> expected = List.of(9, 3, 16, 7, 6, 4);
		assertEquals(expected, lot.levelOrderTraversalRecursive(tree.root));
	}
}
