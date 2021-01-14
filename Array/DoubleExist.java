import java.util.*;

/**
 * Check If N and Its Double Exist
 * <p>
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * More formally check if there exists two indices i and j such that :
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * <p>
 * Example 2:
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * <p>
 * Example 3:
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 * <p>
 * Constraints:
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
class DoubleExist {
  public static void main(String[] args) {
    int[] nums = null;
    boolean isPresent = solve(nums);
    System.out.println(isPresent);
  }

  public static boolean solve(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    if (nums == null || nums.length == 0)
      return false;

    for (int i = 0; i < nums.length; i++) {
      int mul = nums[i] == 0 ? 0 : nums[i] * 2;
      int div = nums[i] == 0 ? 0 : nums[i] / 2;
      if (map.containsKey(mul) || (nums[i] % 2 == 0 && map.containsKey(div))) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }
}
