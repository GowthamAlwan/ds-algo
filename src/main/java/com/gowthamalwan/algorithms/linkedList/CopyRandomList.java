package com.gowthamalwan.algorithms.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
  public Node copyRandomList(Node head) {
    Node iter = head;
    Map<Node, Node> nodeMap = new HashMap<>();
    Node newHead = null;
    Node prev = null;
    while (iter != null) {
      Node newNode = new Node(iter.val);
      if (prev != null) {
        prev.next = newNode;
        prev = newNode;
      } else {
        newHead = newNode;
        prev = newNode;
      }
      newNode.random = iter.random;
      nodeMap.put(iter, newNode);
      iter = iter.next;
    }

    // random pointer mapping
    iter = head;
    Node copyIter = newHead;
    while (iter != null) {
      Node randomNode = iter.random;
      if (randomNode != null) {
        copyIter.random = nodeMap.get(randomNode);
      } else {
        copyIter.random = null;
      }
      copyIter = copyIter.next;
      iter = iter.next;
    }

    return newHead;
  }

  void print(Node head) {
    Node iter = head;
    while (iter != null) {
      System.out.print(iter.val + " ");
      iter = iter.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // [[7,null],[13,0],[11,4],[10,2],[1,0]]
    Node a = new Node(7);
    Node b = new Node(13);
    Node c = new Node(11);
    Node d = new Node(10);
    Node e = new Node(1);

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;

    b.random = a;
    c.random = e;
    d.random = c;
    e.random = a;

    CopyRandomList obj = new CopyRandomList();
    obj.print(a);
    Node result = obj.copyRandomList(a);
    obj.print(result);
  }
}
