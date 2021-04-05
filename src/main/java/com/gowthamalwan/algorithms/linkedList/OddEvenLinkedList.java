package com.gowthamalwan.algorithms.linkedList;

public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode p = head;
    ListNode tempP = p;
    ListNode q = head.next;
    ListNode tempQ = q;
    while (q.next != null) {
      p.next = q.next;
      p = q;
      q = q.next;
    }
    p.next = null;
    while (tempP.next != null) {
      tempP = tempP.next;
    }
    tempP.next = tempQ;
    return head;
  }

  public void printlist(ListNode head) {
    ListNode temp = head;
    while(temp != null) {
      System.out.print(temp.val);
      if (temp.next != null) System.out.print("->");
      temp = temp.next;
    }
    System.out.println();
  }


  public static void main(String[] args) {
    OddEvenLinkedList obj = new OddEvenLinkedList();
    ListNode a = new ListNode(2);
    ListNode b = new ListNode(1);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(5);
    ListNode e = new ListNode(6);
    ListNode f = new ListNode(4);
    ListNode g = new ListNode(7);
    ListNode head = a;
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = g;
    obj.printlist(head);
    ListNode result = obj.oddEvenList(head);
    obj.printlist(result);
  }
}
