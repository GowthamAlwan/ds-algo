package com.gowthamalwan.algorithms.array;

import java.util.*;

/**
 * Find All Numbers Disappeared in an Array
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */
class DisappearedNumber {
  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> result = solve(nums);
    for (int num : result) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static List<Integer> solve(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int j = Math.abs(nums[i]) - 1;
      nums[j] = Math.abs(nums[j]) * -1;
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0)
        list.add(i + 1);
    }
    return list;
  }
}


        
