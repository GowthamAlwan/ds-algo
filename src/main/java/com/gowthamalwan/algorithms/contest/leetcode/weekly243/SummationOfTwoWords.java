package com.gowthamalwan.algorithms.contest.leetcode.weekly243;

/**
 * <a href = 'https://leetcode.com/contest/weekly-contest-243/problems/check-if-word-equals-summation-of-two-words/>
 *   1880. Check if Word Equals Summation of Two Words
 * </a>
 */
public class SummationOfTwoWords {
  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    return valueOfWord(firstWord) + valueOfWord(secondWord) == valueOfWord(targetWord);
  }

  public int valueOfWord(String word) {
    int ans = 0;
    for (char c : word.toCharArray()) {
      ans = ans * 10 + c - 'a';
    }
    return ans;
  }

  public static void main(String[] args) {
    SummationOfTwoWords obj = new SummationOfTwoWords();
    String a = "j", b = "j", c = "bi";
    System.out.println(obj.isSumEqual(a, b, c));
  }
}
