package com.gowthamalwan.algorithms.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/design-circular-queue/">
 *   622. Design Circular Queue
 * </a>
 */
public class MyCircularQueue {
  private List<Integer> queue;
  private int head = -1 , tail = -1;
  public MyCircularQueue(int k) {
    queue = new ArrayList<>(k);
    for (int i = 0; i < k; i++) {
      queue.add(-1);
    }
  }

  public boolean enQueue(int value) {
    if (isFull()) return false;
    if (isEmpty()) {
      queue.set(0, value);
      head = 0;
      tail = 0;
    } else {
      tail = (tail + 1) % queue.size();
      queue.set(tail, value);
    }
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) return false;
    if (head == tail) {
      head = -1;
      tail = -1;
    } else {
      head = (head + 1) % queue.size();
    }
    return true;
  }

  public int Front() {
    if (head == -1) return -1;
    return queue.get(head);
  }

  public int Rear() {
    if (tail == -1) return -1;
    return queue.get(tail);
  }

  public boolean isEmpty() {
    return head == -1 && tail == -1;
  }

  public boolean isFull() {
    return head == 0 && tail == queue.size() - 1 || tail + 1 == head;
  }
}
