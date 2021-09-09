package com.gowthamalwan.algorithms.array;

/**
 * <a href = "https://leetcode.com/problems/search-in-rotated-sorted-array/">
 *   33. Search in Rotated Sorted Array
 * </a>
 * <a href = "https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">
 *   81. Search in Rotated Sorted Array II
 * </a>
 * <a href = "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">
 *   153. Find Minimum in Rotated Sorted Array
 * </a>
 * <a href = "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">
 *   154. Find Minimum in Rotated Sorted Array II
 * </a>
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 2, 3};
        int ans = findMinimum(nums);
        System.out.println(ans);
    }

    public static int findMinimum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
