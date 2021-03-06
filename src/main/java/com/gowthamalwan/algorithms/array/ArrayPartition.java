package com.gowthamalwan.algorithms.array;

import java.util.*;

/**
 * Array Partition I
 * <p>
 * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
 * <p>
 * Example 1:
 * Input: nums = [1,4,3,2]
 * Output: 4
 * Explanation: All possible pairings (ignoring the ordering of elements) are:
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * So the maximum possible sum is 4.
 * <p>
 * Example 2:
 * Input: nums = [6,2,6,5,1,2]
 * Output: 9
 * Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 * <p>
 * Constraints:
 * 1 <= n <= 104
 * nums.length == 2 * n
 * -104 <= nums[i] <= 104
 */
public class ArrayPartition {
  public static void main(String[] args) {
    int[] nums = {6, 2, 6, 5, 1, 2};
    int output = arrayPairSum(nums);
    System.out.println(output);
  }

  public static int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = nums[0];
    for (int i = 2; i < nums.length; i += 2) {
      sum += nums[i];
    }
    return sum;
  }
}