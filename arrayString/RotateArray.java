/**
 * Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Follow up:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class RotateArray {
  public static void main(String[] args) {
    int[] nums = {-1,-100,3,99};
    int k = 2;
    rotate(nums, k);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  public static void rotate(int[] nums, int k) {
    /** 
     * If you rotate the array n times where n is the lenght of the array,
     * you will end up with the same array. So we are eliminating unecessary rotations.
     */
    if (k != 0) {
      k = k % nums.length;
    }

    // if the array length is 1 or the no of rotations is 0, then no need for any rotation
    if (nums.length == 1 || k == 0) return;

    for (int i = 0; i < k; i++) {
      oneStep(nums);
    }
  }

  public static void oneStep(int[] nums) {
    int val = nums[0];
    for(int i = 1; i < nums.length; ++i) {
      int temp = nums[i];
      nums[i] = val;
      val = temp;
    }
    nums[0] = val;
  }
}