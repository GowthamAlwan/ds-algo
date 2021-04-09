package com.gowthamalwan.algorithms.linkedList;

public class MyDoublyLinkedList {
  int val;
  MyDoublyLinkedList prev, next;
  int size;
  MyDoublyLinkedList head;

  MyDoublyLinkedList() {
  }

  MyDoublyLinkedList(int val) {
    this.val = val;
  }

  int get(int index) {
    if (index >= size) {
      return -1;
    }

    MyDoublyLinkedList temp = head;
    for (int i = 0; i < index; ++i) {
      temp = temp.next;
    }
    return temp.val;
  }

  void addAtTail(int val) {
    MyDoublyLinkedList newNode = new MyDoublyLinkedList(val);
    if (head != null) {
      MyDoublyLinkedList temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
      newNode.prev = temp;
    } else {
      head = newNode;
    }
    size++;
  }

  void deleteAtIndex(int index) {
    if (index == 0) {
      head = head.next;
      if (head != null)
        head.prev = null;
      size--;
      return;
    }
    if (index < size) {
      MyDoublyLinkedList iter = new MyDoublyLinkedList();
      iter = head;
      for (int i = 0; i < index; ++i) {
        iter = iter.next;
      }
      MyDoublyLinkedList prev = iter.prev;
      MyDoublyLinkedList next = iter.next;
      prev.next = next;
      if (next != null)
        next.prev = prev;

      size--;
    }
  }

  void addAtHead(int val) {
    MyDoublyLinkedList newNode = new MyDoublyLinkedList(val);
    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    size++;
  }

  void addAtIndex(int index, int val) {
    if (index == 0) {
      addAtHead(val);
      return;
    }

    if (index > size)
      return;

    if (index == size) {
      addAtTail(val);
      return;
    }

    MyDoublyLinkedList iter = new MyDoublyLinkedList();
    MyDoublyLinkedList newNode = new MyDoublyLinkedList(val);
    iter = head;
    for (int i = 1; i <= index; ++i) {
      iter = iter.next;
    }
    MyDoublyLinkedList prev = iter.prev;
    newNode.prev = prev;
    newNode.next = iter;
    prev.next = newNode;
    iter.prev = newNode;
    size++;
  }

  void printForward() {
    MyDoublyLinkedList temp = new MyDoublyLinkedList();
    temp = head;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void printBackward() {
    MyDoublyLinkedList temp = new MyDoublyLinkedList();
    temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.prev;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    MyDoublyLinkedList linkedList = new MyDoublyLinkedList();
    linkedList.addAtHead(9);
    linkedList.printForward();
    linkedList.addAtIndex(1, 1);
    linkedList.printForward();
    linkedList.addAtIndex(1, 7);
    linkedList.printForward();
    linkedList.deleteAtIndex(1);
    linkedList.printForward();
    linkedList.addAtHead(7);
    linkedList.printForward();
    linkedList.addAtHead(4);
    linkedList.printForward();
    linkedList.deleteAtIndex(1);
    linkedList.printForward();
    linkedList.addAtIndex(1, 4);
    linkedList.printForward();
    linkedList.addAtHead(2);
    linkedList.printForward();
    linkedList.deleteAtIndex(5);
    linkedList.printForward();
  }
}