package com.gowthamalwan.algorithms.hashTable;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        Integer index = map.get(nums[i]);
        if (Math.abs(i - index) <= k) {
          return true;
        }
      }
      map.put(nums[i], i);
    }
    return false;
  }

  public static void main(String[] args) {
    ContainsNearbyDuplicate obj = new ContainsNearbyDuplicate();
    int[] nums = {99, 99};
    System.out.println(obj.containsNearbyDuplicate(nums, 2));
  }
}
