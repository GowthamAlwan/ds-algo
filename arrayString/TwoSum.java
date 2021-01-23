import java.util.*;

/**
 * Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add
 * up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Constraints:
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
class TwoSum {
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    solve(nums, target);
  }

  public static void solve(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int c = target - nums[i];
      if (map.containsKey(c)) {
        System.out.println(i + ", " + map.get(c));
      }
      map.put(nums[i], i);
    }
  }
}
