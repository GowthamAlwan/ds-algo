package com.gowthamalwan.algorithms.array;

/**
 * Squares of a Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
 * non-decreasing order.
 * <p>
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * <p>
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a
 * different approach?
 */
class SquareSorted {
  public static void main(String[] args) {
    int[] nums = {-4, -1, 0, 3, 10};

    int[] result = sortedSquares(nums);

    for (int num : result) {
      System.out.print(num + " ");
    }

    System.out.println();
  }

  public static int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];
    int l = -1, r = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        r = i;
        break;
      }
    }
    l = r - 1;

    int q = 0;
    while (l > -1 && r < nums.length) {
      if (nums[l] * nums[l] < nums[r] * nums[r]) {
        result[q++] = nums[l] * nums[l];
        l--;
      } else {
        result[q++] = nums[r] * nums[r];
        r++;
      }
    }

    if (l > -1) {
      while (l > -1) {
        result[q++] = nums[l] * nums[l];
        l--;
      }
    }
    if (r < nums.length) {
      while (r < nums.length) {
        result[q++] = nums[r] * nums[r];
        r++;
      }
    }

    return result;
  }
}

