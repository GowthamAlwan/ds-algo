package com.gowthamalwan.algorithms.binaryTree;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  private boolean isMirror(TreeNode n1, TreeNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n2 == null || n1 == null) return false;
    return (n1.val == n2.val)
      && isMirror(n1.left, n2.right)
      && isMirror(n1.right, n2.left);
  }

  public static void main(String[] args) {
    SymmetricTree obj = new SymmetricTree();
    TreeNode lnode3 = new TreeNode(3);
    TreeNode rnode3 = new TreeNode(3);
    TreeNode lnode2 = new TreeNode(2, null, lnode3);
    TreeNode rnode2 = new TreeNode(2, null, rnode3);
    TreeNode root = new TreeNode(1, lnode2, rnode2);
    System.out.println(obj.isSymmetric(root));
  }
}
