package com.gowthamalwan.algorithms.array;

/**
 * Duplicate Zeros
 * <p>
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to
 * the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * Example 1:
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * <p>
 * Example 2:
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * <p>
 * Note:
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
class DuplicateZeros {
  public static void main(String[] args) {
    int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
    solve(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void solve(int[] nums) {
    int len = nums.length;

    for (int i = 0; i < len; i++) {
      if (nums[i] == 0) {
        for (int j = len - 2; j > i; j--) {
          nums[j + 1] = nums[j];
        }
        if (++i < len) {
          nums[i] = 0;
        }
      }
    }
  }
}