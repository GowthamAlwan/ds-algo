/**
 * Reverse Words in a String
 */
public class ReverseWords {
  public static void main(String[] args) {
    String s = "hello how are you";
    String result = reverseWords3(s);
    System.out.println(result);
  }

  /**
   * Given an input string s, reverse the order of the words.
   * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
   * Return a string of the words in reverse order concatenated by a single space.
   * Note that s may contain leading or trailing spaces or multiple spaces between two words.
   * The returned string should only have a single space separating the words. Do not include any extra spaces.
   *
   * Example 1:
   * Input: s = "the sky is blue"
   * Output: "blue is sky the"
   *
   * Example 2:
   * Input: s = "  hello world  "
   * Output: "world hello"
   * Explanation: Your reversed string should not contain leading or trailing spaces.
   *
   * Example 3:
   * Input: s = "a good   example"
   * Output: "example good a"
   * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
   *
   * Example 4:
   * Input: s = "  Bob    Loves  Alice   "
   * Output: "Alice Loves Bob"
   *
   * Example 5:
   * Input: s = "Alice does not even like bob"
   * Output: "bob like even not does Alice"
   *
   * Constraints:
   * 1 <= s.length <= 104
   * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
   * There is at least one word in s.
   *
   * Follow up:
   * Could you solve it in-place with O(1) extra space?
   */
  public static String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuilder result = new StringBuilder();
    for (int i = words.length - 1; i >= 0; --i) {
      if (!words[i].trim().isEmpty()) {
        result.append(words[i]);
        result.append(" ");
      }
    }
    String finalString = result.toString();
    return finalString.trim();
  }

  /**
   * Given a string, you need to reverse the order of characters in each word within a sentence
   * while still preserving whitespace and initial word order.
   * Example 1:
   * Input: "Let's take LeetCode contest"
   * Output: "s'teL ekat edoCteeL tsetnoc"
   * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
   */
  public static String reverseWords3(String s) {
    String[] words = s.split(" ");
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < words.length; ++i) {
      if (!words[i].trim().isEmpty()) {
        StringBuilder sb = new StringBuilder(words[i]);
        result.append(sb.reverse().toString());
        result.append(" ");
      }
    }
    String finalString = result.toString();
    return finalString.trim();
  }
}