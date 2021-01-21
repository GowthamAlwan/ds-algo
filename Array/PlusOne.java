/**
 * Plus One
 * <p>
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * <p>
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 * <p>
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {
  public static void main(String[] args) {
    int[] digits = {9, 8};
    int[] result = plusOne(digits);
    for (int num : result) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static int[] plusOne(int[] digits) {
    int remainder = 1;
    for (int i = digits.length - 1; i >= 0 ; --i) {
      int newVal = digits[i] + remainder;
      if (newVal == 10) {
        newVal = 0;
        remainder = 1;
      } else {
        remainder = 0;
      }
      digits[i] = newVal;
    }
    
    if (remainder == 1) {
      int[] newDigits = new int[digits.length + 1];
      newDigits[0] = remainder;
      for (int i = 1; i < newDigits.length; ++i) {
        newDigits[i] = digits[i - 1];
      }
      return newDigits;
    }
    return digits;
  }
}
