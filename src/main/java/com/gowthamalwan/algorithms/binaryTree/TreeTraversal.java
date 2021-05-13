package com.gowthamalwan.algorithms.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
  public void preorderTraversal(TreeNode node, List<Integer> list) {
    if (node != null) {
      list.add(node.val);
      preorderTraversal(node.left, list);
      preorderTraversal(node.right, list);
    }
  }

  public void inorderTraversal(TreeNode node, List<Integer> list) {
    if (node != null) {
      inorderTraversal(node.left, list);
      list.add(node.val);
      inorderTraversal(node.right, list);
    }
  }

  public void postorderTraversal(TreeNode node, List<Integer> list) {
    if (node != null) {
      postorderTraversal(node.left, list);
      postorderTraversal(node.right, list);
      list.add(node.val);
    }
  }

  public static void main(String[] args) {
    TreeTraversal obj = new TreeTraversal();
    TreeNode node3 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node4 = new TreeNode(4, node3, node5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2, node1, node4);
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9, node8, null);
    TreeNode node7 = new TreeNode(7, null, node9);
    TreeNode node6 = new TreeNode(6, node2, node7);
    List<Integer> preorderTraversal = new ArrayList<>();
    obj.preorderTraversal(node6, preorderTraversal);
    for (Integer i : preorderTraversal) {
      System.out.print(i);
    }
    System.out.println();

    List<Integer> inorderTraversal = new ArrayList<>();
    obj.inorderTraversal(node6, inorderTraversal);
    for (Integer i : inorderTraversal) {
      System.out.print(i);
    }
    System.out.println();

    List<Integer> postorderTraversal = new ArrayList<>();
    obj.postorderTraversal(node6, postorderTraversal);
    for (Integer i : postorderTraversal) {
      System.out.print(i);
    }
  }
}
