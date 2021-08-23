package com.gowthamalwan.algorithms.array;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">
 *   34. Find First and Last Position of Element in Sorted Array
 * </a>
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = searchFirstOccurence(nums, target);
        int last = searchFirstOccurence(nums, target + 1) - 1;
        if (first <= last) {
            return new int[]{first, last};
        }
        return new int[]{-1, -1};
    }

    public static int searchFirstOccurence(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int first = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                first = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return first;
    }
}
