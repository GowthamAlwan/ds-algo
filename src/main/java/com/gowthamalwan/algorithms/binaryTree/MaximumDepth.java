package com.gowthamalwan.algorithms.binaryTree;

/**
 * <a href = "https://leetcode.com/problems/maximum-depth-of-binary-tree/">
 *   104. Maximum Depth of Binary Tree
 * </a>
 */
public class MaximumDepth {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
