package com.gowthamalwan.algorithms.linkedList;

public class FlattenDoublyLinkedList {
  public Node flatten(Node head) {
    Node iter = head;
    while (iter != null) {
      if (iter.child != null) {
        mergeChild(iter, iter.child, iter.next);
      }
      iter = iter.next;
    }
    return head;
  }

  private void mergeChild(Node prev, Node childHead, Node tailNext) {
    prev.next = childHead;
    prev.child = null;
    childHead.prev = prev;

    while (childHead.next != null) {
      childHead = childHead.next;
    }

    childHead.next = tailNext;
    if (tailNext != null) tailNext.prev = childHead;
  }

  void print(Node head) {
    Node iter = head;
    while (iter != null) {
      System.out.print(iter.val + " ");
      iter = iter.next;
    }
    System.out.println();
  }

  void printBackwards(Node head) {
    Node iter = head;
    while (iter.next != null) {
      iter = iter.next;
    }
    while (iter != null) {
      System.out.print(iter.val + " ");
      iter = iter.prev;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);
    Node h = new Node(8);
    Node i = new Node(9);
    Node j = new Node(10);
    Node k = new Node(11);
    Node l = new Node(12);

    // [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

    a.next = b;
    b.prev = a;
    b.next = c;
    c.prev = b;
    c.next = d;
    d.prev = c;
    d.next = e;
    e.prev = d;
    e.next = f;
    f.prev = e;

    g.next = h;
    h.prev = g;
    h.next = i;
    i.prev = h;
    i.next = j;
    j.prev = i;

    k.next = l;
    l.prev = k;

    c.child = g;
    h.child = k;

    FlattenDoublyLinkedList obj = new FlattenDoublyLinkedList();
    a = obj.flatten(a);
    obj.print(a);
    obj.printBackwards(a);
  }
}
