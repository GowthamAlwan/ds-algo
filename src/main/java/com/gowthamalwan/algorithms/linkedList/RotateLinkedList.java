package com.gowthamalwan.algorithms.linkedList;

public class RotateLinkedList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    int length = 0;
    ListNode iter = head;
    while (iter != null) {
      length++;
      iter = iter.next;
    }

    if (k != 0) k = k % length;

    for (int i = 0; i < k; i++) {
      head = rotateOnce(head);
    }
    return head;
  }

  public ListNode rotateOnce(ListNode head) {
    ListNode iter = head;
    int mem = Integer.MIN_VALUE;
    while (iter != null) {
      int temp = iter.val;
      iter.val = mem;
      mem = temp;
      iter = iter.next;
    }
    head.val = mem;
    return head;
  }

  void print(ListNode head) {
    ListNode iter = head;
    while (iter != null) {
      System.out.print(iter.val + " ");
      iter = iter.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode();

    ListNode a = new ListNode(0);
    ListNode b = new ListNode(1);
    ListNode c = new ListNode(2);
    // ListNode d = new ListNode(4);
    // ListNode e = new ListNode(5);
    l1 = a;
    a.next = b;
    b.next = c;
    // c.next = d;
    // d.next = e;

    RotateLinkedList mg = new RotateLinkedList();
    mg.print(l1);
    ListNode result = mg.rotateRight(l1, 300);
    mg.print(result);
  }
}
