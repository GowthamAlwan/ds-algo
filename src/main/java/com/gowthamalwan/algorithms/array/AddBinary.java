package com.gowthamalwan.algorithms.array;

/**
 * Add Binary
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
  public static void main(String[] args) {
    String a = "11", b = "11";
    System.out.println(addBinary(a, b));
  }

  public static String addBinary(String a, String b) {
    char[] aChar = a.toCharArray();
    char[] bChar = b.toCharArray();
    StringBuilder result = new StringBuilder();
    int p = aChar.length - 1;
    int q = bChar.length - 1;
    int remainder = 0;
    while(p > -1 && q > -1) {
      int sum = Character.getNumericValue(aChar[p--]) + Character.getNumericValue(bChar[q--]) + remainder;
      if (sum == 2) {
        remainder = 1;
        sum = 0;
      } else if (sum == 3) {
        remainder = 1;
        sum = 1;
      } else {
        remainder = 0;
      }
      result.append(sum);
    }
    if (p > -1) {
      while(p > -1) {
        int sum = Character.getNumericValue(aChar[p--]) + remainder;
        if (sum == 2) {
          remainder = 1;
          sum = 0;
        } else {
          remainder = 0;
        }
        result.append(sum);
      }
    }
    if (q > -1) {
      while(q > -1) {
        int sum = Character.getNumericValue(bChar[q--]) + remainder;
        if (sum == 2) {
          remainder = 1;
          sum = 0;
        } else {
          remainder = 0;
        }
        result.append(sum);
      }
    }
    if (remainder == 1) {
      result.append(1);
    }
    return result.reverse().toString();
  }
}