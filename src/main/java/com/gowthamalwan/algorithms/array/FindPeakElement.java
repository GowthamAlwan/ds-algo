package com.gowthamalwan.algorithms.array;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,7};
        int ans = findPeakElement(nums);
        System.out.println(ans);
    } 

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid + 1 < n && nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
