package com.gowthamalwan.algorithms.hashTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MyHashMap {

  private final int BUCKET_SIZE = 10000;
  private List<List<MapVal>> buckets;

  /** Initialize your data structure here. */
  public MyHashMap() {
    buckets = new ArrayList<>(BUCKET_SIZE);
    for (int i = 0; i < BUCKET_SIZE; i++) {
      buckets.add(null);
    }
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int index = key % BUCKET_SIZE;
    List<MapVal> mapVal = buckets.get(index);
    if (mapVal == null) {
      List<MapVal> newMapVal = new LinkedList<>();
      newMapVal.add(new MapVal(key, value));
      buckets.set(index, newMapVal);
    } else {
      Iterator<MapVal> iter = mapVal.iterator();
      while (iter.hasNext()) {
        MapVal mv = iter.next();
        if (mv.key == key) {
          mv.val = value;
          return;
        }
      }
      mapVal.add(new MapVal(key, value));
    }
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map
   * contains no mapping for the key
   */
  public int get(int key) {
    int index = key % BUCKET_SIZE;
    List<MapVal> mapVal = buckets.get(index);
    if (mapVal != null) {
      Iterator<MapVal> iter = mapVal.iterator();
      while (iter.hasNext()) {
        MapVal mv = iter.next();
        if (mv.key == key) {
          return mv.val;
        }
      }
    }
    return -1;
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping
   * for the key
   */
  public void remove(int key) {
    int index = key % BUCKET_SIZE;
    List<MapVal> mapVal = buckets.get(index);
    if (mapVal != null) {
      mapVal = mapVal.stream().filter(mv -> mv.key != key).collect(Collectors.toList());
      buckets.set(index, mapVal);
    }
  }

  private static class MapVal {
    private int key;
    private int val;

    public MapVal(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  public static void main(String[] args) {
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 1); // The map is now [[1,1]]
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    System.out.println(myHashMap.get(1)); // return 1, The map is now [[1,1], [2,2]]
    System.out.println(myHashMap.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    System.out.println(myHashMap.get(2)); // return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    System.out.println(myHashMap.get(2)); // return -1 (i.e., not found), The map is now [[1,1]]
  }

}