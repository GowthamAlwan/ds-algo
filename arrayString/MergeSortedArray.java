/**
 * Merge Sorted Array
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough
 * space (size that is equal to m + n) to hold additional elements from nums2.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * <p>
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * <p>
 * Constraints:
 * 0 <= n, m <= 200
 * 1 <= n + m <= 200
 * nums1.length == m + n
 * nums2.length == n
 * -109 <= nums1[i], nums2[i] <= 109
 */
class MergeSortedArray {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3, n = 3;
    solve(nums1, m, nums2, n);
    for (int num : nums1) {
      System.out.print(num + " ");
    }
  }

  public static void solve(int[] nums1, int m, int[] nums2, int n) {
    int a = 0, b = 0;
    while (a < m && b < n) {
      if (nums1[a] <= nums2[b]) {
        a++;
      } else {
        for (int j = m - 1; j >= a; j--) {
          nums1[j + 1] = nums1[j];
        }
        nums1[a] = nums2[b++];
        m++;
      }
    }

    if (b < n) {
      for (int i = b; i < n; i++) {
        nums1[a++] = nums2[i];
      }
    }
  }
}