package com.gowthamalwan.algorithms.linkedList;

/**
 * Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next
 * pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    ListNode slow = head;
    ListNode fast = head;
    while(slow.next != null && fast.next != null) {
      slow = slow.next;
      if (fast.next.next == null)
        return false;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while(slow.next != null && fast.next != null) {
      slow = slow.next;
      if (fast.next.next == null)
        return null;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while(slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return fast;
      }
    }
    return null;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}
