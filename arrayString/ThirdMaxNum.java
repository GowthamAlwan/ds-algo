/**
 * Third Maximum Number
 * <p>
 * Given integer array nums, return the third maximum number in this array. If the third maximum does not exist,
 * return the maximum number.
 * <p>
 * Example 1:
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * <p>
 * Example 2:
 * Input: nums = [1,2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * <p>
 * Example 3:
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * 231 <= nums[i] <= 231 - 1
 * <p>
 * Follow up: Can you find an O(n) solution?
 */
class ThirdMaxNum {
  public static void main(String[] args) {
    int[] nums = {-2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1};
    int result = solve(nums);
    System.out.println(result);
  }

  public static int solve(int[] nums) {
    Integer a, b, c;
    a = b = c = null;
    for (Integer num : nums) {

      if (num.equals(a) || num.equals(b) || num.equals(c)) {
        continue;
      }

      if (c == null || num > c) {
        a = b;
        b = c;
        c = num;
      } else if (b == null || num > b) {
        a = b;
        b = num;
      } else if (a == null || num > a) {
        a = num;
      }
    }
    return (a == null) ? c : a;
  }
}