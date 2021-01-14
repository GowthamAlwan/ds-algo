/**
 * Product of Array Except Self
 * <p>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * <p>
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of
 * the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the
 * purpose of space complexity analysis.)
 */
class ProductArray {
  public static void main(String[] args) {
    int[] arr = {4, 5, 1, 8, 2};
    int[] result = usingDivision(arr);
    for (int n : result) {
      System.out.print(n + " ");
    }
    System.out.println();

    int[] result1 = leftRightProduct(arr);
    for (int n : result1) {
      System.out.print(n + " ");
    }

    System.out.println();
  }

  public static int[] usingDivision(int[] arr) {
    int[] result = new int[arr.length];
    int product = 1;
    for (int i = 0; i < arr.length; i++) {
      product *= arr[i];
    }

    for (int i = 0; i < arr.length; i++) {
      result[i] = product / arr[i];
    }
    return result;
  }

  public static int[] leftRightProduct(int[] nums) {
    int len = nums.length;
    int[] L = new int[len];
    int[] R = new int[len];

    for (int i = 0; i < len; i++) {
      if (i == 0) {
        L[i] = 1;
        continue;
      }
      L[i] = nums[i - 1] * L[i - 1];
    }

    for (int i = len - 1; i >= 0; i--) {
      if (i == len - 1) {
        R[i] = 1;
        continue;
      }
      R[i] = nums[i + 1] * R[i + 1];
    }

    int[] result = new int[len];
    for (int i = 0; i < len; i++) {
      result[i] = L[i] * R[i];
    }

    return result;
  }
}
