package com.gowthamalwan.algorithms.linkedList;

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head.next == null) return true;
    ListNode temp = head;
    ListNode firstHalfPointer = head;
    int size = 0;
    while (temp != null) {
      size += 1;
      temp = temp.next;
    }
    int secondHalf = size % 2 == 0 ? size / 2 : (size / 2) + 1;
    ListNode secondHalfPointer = head;
    for (int i = 0; i < secondHalf; ++i) {
      secondHalfPointer = secondHalfPointer.next;
    }

    secondHalfPointer = reverseList(secondHalfPointer);

    while (secondHalfPointer != null) {
      if (firstHalfPointer.val != secondHalfPointer.val)
        return false;

      firstHalfPointer = firstHalfPointer.next;
      secondHalfPointer = secondHalfPointer.next;
    }
    return true;
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


  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = null;
    while(cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    head = prev;
    return head;
  }

  public static void main(String[] args) {
    PalindromeLinkedList obj = new PalindromeLinkedList();
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    ListNode e = new ListNode(3);
    ListNode f = new ListNode(2);
    // ListNode g = new ListNode(1);
    ListNode head = a;
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    // f.next = g;
    obj.printlist(head);
    boolean isPalindrome = obj.isPalindrome(head);
    System.out.println(isPalindrome);
  }
}
