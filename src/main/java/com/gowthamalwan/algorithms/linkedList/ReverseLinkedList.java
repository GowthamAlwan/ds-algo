package com.gowthamalwan.algorithms.linkedList;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode it = head.next;
    while (it != null) {
      ListNode newHead = it;
      it = it.next;
      head = removeNode(head, newHead);
      head = addAtHead(head, newHead);
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

  public ListNode addAtHead(ListNode head, ListNode newHead) {
    if (head != null) {
      newHead.next = head;
      head = newHead;
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
    ReverseLinkedList obj = new ReverseLinkedList();
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
    obj.printlist(head);
    ListNode result = obj.reverseList(head);
    obj.printlist(result);
  }
}
