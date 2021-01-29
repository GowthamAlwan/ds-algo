package com.gowthamalwan.algorithms.array;

/**
 * Remove Element
 * <p>
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
 * <p>
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3]
 * Explanation: Your function should return length = 5, with the first five elements of nums
 * containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary. It doesn't matter what
 * values are set beyond the returned length.
 * <p>
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
class RemoveElems {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2};
    int len = solve(nums, 2);

    for (int i = 0; i < len; i++) {
      System.out.print(nums[i] + " ");
    }

    System.out.println();
  }

  public static int solve(int[] nums, int val) {
    int i = 1;
    int p = nums[0];
    for (int l = 1; l < nums.length; l++) {
      if (nums[l] != p) {
        nums[i++] = nums[l];
      }
      p = nums[l];
    }
    return i;
  }
}