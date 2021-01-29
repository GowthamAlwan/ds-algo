package com.gowthamalwan.algorithms.array;

/**
 * Find Pivot Index
 * <p>
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum
 * of all the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most
 * pivot index.
 * <p>
 * Example 1:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * <p>
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * <p>
 * Example 3:
 * Input: nums = [-1, -1, -1, 0, 1, 1]
 * Output: 0
 * Explanation:
 * The sum of numbers to the left of the index that is none is 0 which is equal to the sum of numbers to the right of
 * index 0
 * Constraints:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class PivotIndex {
  public static void main(String[] args) {
    int[] nums = {-1, -1, -1, 0, 1, 1};
    int result = pivotIndex(nums);
    System.out.println(result);
  }

  public static int pivotIndex(int[] nums) {
    int len = nums.length;
    int[] L = new int[len];

    for (int i = 0; i < len; ++i) {
      if (i == 0) {
        L[i] = 0;
      } else {
        L[i] = L[i - 1] + nums[i - 1];
      }
    }

    for (int i = 0; i < len; ++i) {
      int r = nums[len - 1] + L[len - 1] - L[i] - nums[i];
      if (L[i] == r)
        return i;
    }

    return -1;
  }
}
