package com.gowthamalwan.algorithms.array;

/**
 * Implement strStr()
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 * <p>
 * Constraints:
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 */
public class HaystackNeedle {
  public static void main(String[] args) {
    String haystack = "mississippi";
    String needle = "issipi";
    int result = strStr(haystack, needle);
    System.out.println(result);
  }

  public static int strStr(String haystack, String needle) {
    if (needle == null || needle.length() == 0) return 0;

    if (needle.length() > haystack.length()) return -1;

    char[] hChar = haystack.toCharArray();
    char[] nChar = needle.toCharArray();
    for (int i = 0; i < hChar.length; i++) {
      if (hChar[i] == nChar[0]) {
        int t = i;
        boolean allMatch = true;
        if (hChar.length - i - 1 > nChar.length - 2) {
          for (int j = 1; j < nChar.length; j++) {
            if (hChar[++t] != nChar[j]) {
              allMatch = false;
              break;
            }
          }
          if (allMatch) {
            return i;
          }
        }
      }
    }

    return -1;
  }
}