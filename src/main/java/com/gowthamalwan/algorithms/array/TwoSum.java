package com.gowthamalwan.algorithms.array;

import java.util.*;

/**
 * <a href = "https://leetcode.com/problems/two-sum/">
 *   1. Two Sum
 * </a>
 */
class TwoSum {
  public static void main(String[] args) {
    int[] nums = {2, 3, 4};
    int target = 6;
    usingMap(nums, target);
    int[] result = usingTwoPointers(nums, target);
    for (int num : result) {
      System.out.print(num + " ");
    } 
  }

  public static void usingMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int c = target - nums[i];
      if (map.containsKey(c)) {
        System.out.println(i + ", " + map.get(c));
      }
      map.put(nums[i], i);
    }
  }

  public static int[] usingTwoPointers(int[] numbers, int target) {
    int[] result = new int[2];
    for (int i = 0; i < numbers.length - 1; ++i) {
      for (int j = i; j < numbers.length; ++j) {
        if (numbers[i] + numbers[j] == target && i < j) {
          result[0] = i + 1;
          result[1] = j + 1;
        }
      }
    }
    return result;
  }
}
