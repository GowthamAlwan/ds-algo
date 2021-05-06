package com.gowthamalwan.algorithms.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays {
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums1) {
      if (map.containsKey(num)) {
        Integer occurence = map.get(num);
        map.put(num, ++occurence);
      } else {
        map.put(num, 1);
      }
    }
    for (int num : nums2) {
      if (map.containsKey(num) && map.get(num) > 0) {
        result.add(num);
        Integer occurence = map.get(num);
        map.put(num, --occurence);
      }
    }
    int[] returnList = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      returnList[i] = result.get(i);
    }
    return returnList;
  }

  public static void main(String[] args) {
    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};
    IntersectionOfArrays obj = new IntersectionOfArrays();
    int[] result = obj.intersect(nums1, nums2);
    for (int i : result) {
      System.out.println(i);
    }
  }
}
