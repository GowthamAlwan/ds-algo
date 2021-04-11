package com.gowthamalwan.algorithms.linkedList;

/**
 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
 */
public class MergeSortedLinkedList {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode p = l1;
    ListNode q = l2;
    while (q != null) {
      ListNode prev = null;
      ListNode curr = p;
      boolean isAdded = false;
      while (curr != null) {
        if (curr.val >= q.val) {
          ListNode newNode = new ListNode(q.val);
          if (prev == null) {
            newNode.next = curr;
            p = newNode;
          } else {
            newNode.next = curr;
            prev.next = newNode;
          }
          isAdded = true;
          break;
        }
        prev = curr;
        curr = curr.next;
      }
      if (!isAdded) {
        ListNode newNode = new ListNode(q.val);
        prev.next = newNode;
        isAdded = false;
      }
      q = q.next;
    }
    return p;
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
    ListNode l2 = new ListNode();

    ListNode a = new ListNode(1);
    // ListNode b = new ListNode(2);
    // ListNode c = new ListNode(4);
    // ListNode d = new ListNode(25);
    l1 = a;
    // a.next = b;
    // b.next = c;
    // c.next = d;

    ListNode x = new ListNode(2);
    // ListNode y = new ListNode(3);
    // ListNode z = new ListNode(4);
    // ListNode za = new ListNode(15);
    l2 = x;
    // x.next = y;
    // y.next = z;
    // z.next = za;

    MergeSortedLinkedList mg = new MergeSortedLinkedList();
    ListNode result = mg.mergeTwoLists(l1, l2);
    mg.print(result);
  }
}
