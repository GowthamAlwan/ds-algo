package com.gowthamalwan.algorithms.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Integer> rootLevel = new ArrayList<>();
    rootLevel.add(root.val);
    result.add(rootLevel);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (queue.peek() != null) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          level.add(node.left.val);
          queue.add(node.left);
        }
        if (node.right != null) { 
          level.add(node.right.val);
          queue.add(node.right);
        }
      }
      if (!level.isEmpty()) result.add(level);
    }
    return result;
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

    System.out.println();
    List<List<Integer>> levelOrderTraversal = obj.levelOrder(node6);
    System.out.println("[");
    for (List<Integer> level : levelOrderTraversal) {
      System.out.print("[");
      for (Integer val : level) {
        System.out.print(val + ", ");
      }
      System.out.println("]");
    }
    System.out.println("]");
  }
}
