package com.gowthamalwan.algorithms.linkedList;

public class AddTwoNumbers {

  /**
   * Only works for linked list of small size(int max range).
   */
  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    ListNode p = l1;
    ListNode q = l2;
    int num1 = 0;
    int num2 = 0;
    for (int i = 0; p != null; i++) {
      if (i != 0) {
        num1 += p.val * Math.pow(10, i);
      } else {
        num1 += p.val;
      }
      p = p.next;
    }
    for (int i = 0; q != null; i++) {
      if (i != 0) {
        num2 += q.val * Math.pow(10, i);
      } else {
        num2 += q.val;
      }
      q = q.next;
    }

    int result = num1 + num2;
    if (result == 0) {
      return new ListNode(0);
    }
    ListNode returnList = null;
    while (result > 0) {
      int rem = result % 10;
      returnList = addAtTail(returnList, rem);
      result = result / 10;
    }
    return returnList;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p = l1;
    ListNode q = l2;
    int carry = 0;
    ListNode returnList = null;
    while (p != null || q != null) {
      int v1 = p == null ? 0 : p.val;
      int v2 = q == null ? 0 : q.val;
      int sum = v1 + v2 + carry;
      carry = 0;
      if (sum >= 10) {
        sum = sum - 10;
        carry = 1;
      }
      returnList = addAtTail(returnList, sum);
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry != 0) {
      returnList = addAtTail(returnList, carry);
    }
    return returnList;
  }

  ListNode addAtTail(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    if (head == null) {
      head = newNode;
    } else {
      ListNode iter = head;
      while (iter.next != null) {
        iter = iter.next;
      }
      iter.next = newNode;
    }
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

    // [9]
    // [1,9,9,9,9,9,9,9,9,9]

    ListNode l1 = new ListNode();
    ListNode l2 = new ListNode();

    ListNode a = new ListNode(9);
    ListNode b = new ListNode(4);
    ListNode c = new ListNode(3);
    l1 = a;
    a.next = b;
    b.next = c;

    ListNode x1 = new ListNode(1);
    ListNode x2 = new ListNode(9);
    ListNode x3 = new ListNode(9);
    // ListNode x4 = new ListNode(9);
    // ListNode x5 = new ListNode(9);
    // ListNode x6 = new ListNode(9);
    // ListNode x7 = new ListNode(9);
    // ListNode x8 = new ListNode(9);
    // ListNode x9 = new ListNode(9);
    // ListNode x10 = new ListNode(9);

    l2 = x1;
    x1.next = x2;
    x2.next = x3;
    // x3.next = x4;
    // x4.next = x5;
    // x5.next = x6;
    // x6.next = x7;
    // x7.next = x8;
    // x8.next = x9;
    // x9.next = x10;

    AddTwoNumbers mg = new AddTwoNumbers();
    ListNode result = mg.addTwoNumbers(l1, l2);
    mg.print(result);
  }
}
