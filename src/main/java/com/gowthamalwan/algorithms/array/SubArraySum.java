package com.gowthamalwan.algorithms.array;

public class SubArraySum {
  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 2, 4, 3};
    int s = 7;
    int result = minSubArrayLen(s, nums);
    System.out.println(result);
  }

  public static int minSubArrayLen(int s, int[] nums) {
    int result = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      while(sum >= s) {
        result = Math.min(result, i + 1 - left);
        sum -= nums[left++];
      }
    }
    return result != Integer.MAX_VALUE ? result : 0;
  }
}