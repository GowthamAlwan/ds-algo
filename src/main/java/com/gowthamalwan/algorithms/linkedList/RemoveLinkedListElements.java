package com.gowthamalwan.algorithms.linkedList;

public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) 
      return head;

    ListNode p = head;
    while (p != null) {
      if (p.val == val)
        head = removeNode(head, p);
      
      p = p.next;
    }

    return head;
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
    RemoveLinkedListElements obj = new RemoveLinkedListElements();
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(1);
    ListNode c = new ListNode(1);
    ListNode d = new ListNode(1);
    ListNode e = new ListNode(1);
    ListNode f = new ListNode(1);
    ListNode head = a;
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    obj.printlist(head);
    ListNode result = obj.removeElements(head, 1);
    obj.printlist(result);
  }
}
