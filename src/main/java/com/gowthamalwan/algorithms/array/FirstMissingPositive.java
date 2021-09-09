package com.gowthamalwan.algorithms.array;

/**
 * <a href = "https://leetcode.com/problems/first-missing-positive/">
 *   41. First Missing Positive
 * </a>
 */
class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < n && nums[i] != nums[correctIndex]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return n + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}