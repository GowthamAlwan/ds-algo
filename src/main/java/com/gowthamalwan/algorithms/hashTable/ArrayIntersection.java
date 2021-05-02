package com.gowthamalwan.algorithms.hashTable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArrayIntersection {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> uniqNums = new HashSet<>();
    Set<Integer> intersection = new HashSet<>();
    for (int num : nums1) {
      uniqNums.add(num);
    }
    for (int num : nums2) {
      if (uniqNums.contains(num)) {
        intersection.add(num);
      }
    }
    int[] result = new int[intersection.size()];
    Iterator<Integer> iter = intersection.iterator();
    int i = 0;
    while(iter.hasNext()) {
      result[i++] = iter.next();
    }
    return result;
  }

  public static void main(String[] args) {
    ArrayIntersection obj = new ArrayIntersection();
    int[] nums1 = {1, 2};
    int[] nums2 = {1, 2};

    int[] result = obj.intersection(nums1, nums2);
    for (int num : result) {
      System.out.println(num);
    }
  }
}