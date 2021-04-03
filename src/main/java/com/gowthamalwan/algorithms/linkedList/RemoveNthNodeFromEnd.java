package com.gowthamalwan.algorithms.linkedList;

public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p = head;
    ListNode q = head;

    for (int i = 1; i < n; i++) {
      if (q == null)
        return null;
      q = q.next;
    }

    while (q.next != null) {
      p = p.next;
      q = q.next;
    }

    return removeNode(head, p);
  }

  public ListNode removeNode(ListNode head, ListNode node) {
    ListNode list = head;
    if (list == node) {
      head = head.next;
      return head;
    }

    while (list != null) {
      if (list.next == node) {
        list.next = node.next;
        return head;
      }
      list = list.next;
    }
    return head;
  }

  public static void main(String[] args) {
    RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    ListNode e = new ListNode(5);
    ListNode f = new ListNode(6);
    ListNode head = a;
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    while (head != null) {
      System.out.print(head.val + "->");
      head = head.next;
    }
    System.out.println();
    head = a;
    ListNode result = obj.removeNthFromEnd(head, 6);
    while (result != null) {
      System.out.print(result.val + "->");
      result = result.next;
    }
    System.out.println();
  }
}
