package com.gowthamalwan.algorithms.array;

/**
 * <a href = "https://leetcode.com/problems/split-array-largest-sum/">
 *   410. Split Array Largest Sum
 * </a>
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 3;
        int ans = splitArray(nums, m);
        System.out.println(ans);
    }
    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int fragments = 1;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > mid) {
                    sum = nums[i];
                    fragments++;
                } else {
                    sum += nums[i];
                }
            }

            if (fragments <= m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
