package com.gowthamalwan.algorithms.stack;

/**
 * <a href = "https://leetcode.com/problems/min-stack/">
 *   155. Min Stack
 * </a>
 */
public class MinStack {
  private class Node {
    private final int val;
    private final int min;
    private Node next;

    public Node (int val, int min) {
      this.val = val;
      this.min = min;
    }

    public Node (int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }

  private Node stack;

  public void push(int val) {
    if (stack == null) {
      stack = new Node(val, val);
    } else {
      stack = new Node(val, Math.min(val, stack.min), stack);
    }
  }

  public void pop() {
    stack = stack.next;
  }

  public int top() {
    return stack.val;
  }

  public int getMin() {
    return stack.min;
  }
}
