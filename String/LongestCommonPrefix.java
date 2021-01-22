/**
 * Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Constraints:
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = {"reflower","flow","flight"};
    String output = longestCommonPrefix(strs);
    System.out.println(output);
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; ++i) {
      if (strs[i].length() < prefix.length()) {
        prefix = strs[i];
      }
    }
    for (int i = 0; i < strs.length; ++i) {
      String word = strs[i];
      int p = 0;
      while(p < word.length() && p < prefix.length()) {
        if (word.charAt(p) != prefix.charAt(p)) {
          prefix = word.substring(0, p);
          break;
        }
        p++;
      }
    }
    return prefix;
  }
}