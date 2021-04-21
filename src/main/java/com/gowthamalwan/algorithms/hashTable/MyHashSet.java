package com.gowthamalwan.algorithms.hashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

  private final int BUCKET_SIZE = 100;
  private List<List<Integer>> buckets;

  public MyHashSet() {
    buckets = new ArrayList<>(BUCKET_SIZE);
    for (int i = 0; i < BUCKET_SIZE; i++) {
      buckets.add(null);
    }
  }
  
  public void add(int key) {
    int index = key % BUCKET_SIZE;
    List<Integer> childList = buckets.get(index);
    if (childList == null) {
      List<Integer> list = new LinkedList<>();
      list.add(key);
      buckets.set(index, list);
    } else {
      if (!childList.contains(key)) {
        childList.add(key);
      }
    }
  }
  
  public void remove(int key) {
    int index = key % BUCKET_SIZE;
    List<Integer> childList = buckets.get(index);
    if (childList != null) {
      childList.remove(Integer.valueOf(key));
    }
  }
  
  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int index = key % BUCKET_SIZE;
    List<Integer> childList = buckets.get(index);
    return childList != null && childList.contains(key);
  }

  public static void main(String[] args) {
    MyHashSet set = new MyHashSet();
    set.add(1);
    set.add(2);
    System.out.println(set.contains(1));
    System.out.println(set.contains(3));
    set.add(2);
    System.out.println(set.contains(2));
    set.remove(2);
    System.out.println(set.contains(2));
  }
  
}
