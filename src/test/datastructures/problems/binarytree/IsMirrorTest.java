package datastructures.problems.binarytree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

public class IsMirrorTest {
	@Test
	public void testSimpleTreeFalse() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		IsMirror im = new IsMirror();
		assertFalse(im.isMirror(tree.root, tree.root));
	}
	@Test
	public void testSimpleTreeTrue() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		BinaryTree mirrorTree = new BinaryTree(new TreeNode (9));
		mirrorTree.root.right = new TreeNode(5);
		mirrorTree.root.left = new TreeNode(16);
		mirrorTree.root.right.right = new TreeNode(3);
		mirrorTree.root.right.left = new TreeNode(7);
		mirrorTree.root.left.left = new TreeNode(18);
		
		IsMirror im = new IsMirror();
		assertTrue(im.isMirror(tree.root, mirrorTree.root));
	}
	@Test
	public void testSimpleTreeFalse2() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		BinaryTree mirrorTree = new BinaryTree(new TreeNode (19));
		mirrorTree.root.right = new TreeNode(22);
		mirrorTree.root.left = new TreeNode(21);
		mirrorTree.root.right.right = new TreeNode(3);
		mirrorTree.root.right.left = new TreeNode(18);
		mirrorTree.root.left.left = new TreeNode(6);
		
		IsMirror im = new IsMirror();
		assertTrue(im.isMirror(tree.root, mirrorTree.root));
	}
	@Test
	public void testSimpleTreeNull() {
		BinaryTree tree = BinaryTreeUtility.getSimpleTree();
		
		IsMirror im = new IsMirror();
		assertTrue(im.isMirror(tree.root, null));
	}
}