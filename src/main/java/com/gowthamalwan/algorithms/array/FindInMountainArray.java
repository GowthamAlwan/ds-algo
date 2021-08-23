package com.gowthamalwan.algorithms.array;

/**
 * <a href = "https://leetcode.com/problems/find-in-mountain-array/">
 *   1095. Find in Mountain Array
 * </a>
 */
public class FindInMountainArray {
    public static void main(String[] args) {
        MountainArray1 mountainArray = new MountainArray1();
        int ans = findInMountainArray(2, mountainArray);
        System.out.println(ans);
    }

    public static int findInMountainArray(int target, MountainArray1 mountainArr) {
        int peakIndex = findPeak(mountainArr);
        int firstSearch = search(mountainArr, target, 0, peakIndex, true);
        if (firstSearch == -1) {
            return search(mountainArr, target, peakIndex, mountainArr.length() - 1, false);
        }
        return firstSearch;
    }

    private static int findPeak(MountainArray1 mountainArray) {
        int start = 0;
        int end = mountainArray.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArray.get(mid) > mountainArray.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int search(MountainArray1 mountainArray, int target, int start, int end, boolean isIncreasing) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArray.get(mid) == target) {
                return mid;
            }
            if (isIncreasing) {
                if (mountainArray.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (mountainArray.get(mid) < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

class MountainArray1 {
    private int[] arr = {1,2,3,4,5,3,1};

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}
