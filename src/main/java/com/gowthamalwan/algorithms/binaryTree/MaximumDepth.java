package com.gowthamalwan.algorithms.binaryTree;

public class MaximumDepth {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
  }

  public static void main(String[] args) {
    TreeNode node3 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node4 = new TreeNode(4, node3, node5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2, node1, node4);
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9, node8, null);
    TreeNode node7 = new TreeNode(7, null, node9);
    TreeNode node6 = new TreeNode(6, node2, node7);
    MaximumDepth obj = new MaximumDepth();
    System.out.println("Depth: " + obj.maxDepth(node6));
  }
}
