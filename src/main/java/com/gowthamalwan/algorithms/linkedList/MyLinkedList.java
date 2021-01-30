package com.gowthamalwan.algorithms.linkedList;

/**
 * Design Linked List
 * <p>
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next.
 * val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node
 * in the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 * <p>
 * Example 1:
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * <p>
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * <p>
 * Constraints:
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
 */
public class MyLinkedList {

	int val;
	int length;
	MyLinkedList head;
	MyLinkedList next;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		this.length = 0;
	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (index >= length) {
			return -1;
		}
		MyLinkedList nodeAtIndex = this.head;
		for (int i = 1; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.next;
		}
		return nodeAtIndex.val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion,
	 * the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		MyLinkedList newHead = new MyLinkedList();
		newHead.val = val;
		newHead.next = this.head;
		this.head = newHead;
		this.length++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		MyLinkedList tail = new MyLinkedList();
		tail.val = val;
		if (length == 0) {
			this.head = tail;
			this.length++;
			return;
		}
		MyLinkedList curTail = head;
		for (int i = 1; i < this.length; i++) {
			curTail = curTail.next;
		}
		curTail.next = tail;
		this.length++;
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of
	 * linked list, the node will be appended to the end of linked list. If index is greater than the length,
	 * the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		if (index == length) {
			addAtTail(val);
			return;
		} else if (index == 0) {
			addAtHead(val);
			return;
		} else if (index > this.length) {
			return;
		} else {
			MyLinkedList before = this.head;
			for (int i = 1; i < index; i++) {
				before = before.next;
			}
			MyLinkedList nodeAtIndex = before.next;
			MyLinkedList newNode = new MyLinkedList();
			newNode.val = val;
			newNode.next = nodeAtIndex;
			before.next = newNode;
			this.length++;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < length) {
			MyLinkedList before = this.head;
			for (int i = 1; i < index; ++i) {
				before = before.next;
			}
			if (index == length) {
				before.next = null;
				this.length--;
			}
			else if (index == 0) {
				this.head = head.next;
			}
			else {
				before.next = before.next.next;
				this.length--;
			}
		}
	}

	public void print() {
		System.out.print("[");
		MyLinkedList node = this.head;
		for(int i = 0; i < this.length; ++i) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println("]");
	}

	/**
	* Your MyLinkedList object will be instantiated and called as such:
	* MyLinkedList obj = new MyLinkedList();
	* int param_1 = obj.get(index);
	* obj.addAtHead(val);
	* obj.addAtTail(val);
	* obj.addAtIndex(index,val);
	* obj.deleteAtIndex(index);
	*/
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtIndex(0, 10);
		obj.addAtIndex(0, 20);
		obj.addAtIndex(1, 30);
		obj.get(0);
		obj.print();
	}
}