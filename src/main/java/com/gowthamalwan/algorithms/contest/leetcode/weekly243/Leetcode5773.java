package com.gowthamalwan.algorithms.contest.leetcode.weekly243;

import java.util.ArrayList;
import java.util.List;

public class Leetcode5773 {
  public String maxValue(String n, int x) {
    boolean positive = true;
    List<String> numbers = new ArrayList<>();
    for (int i = 0; i <= n.length(); i++) {
      StringBuffer buff = new StringBuffer(n);
      if (i == n.length()) {
        buff.append(String.valueOf(x));
      } else {
        if (n.charAt(i) == '-') {
          positive = false;
          continue;
        }
        buff.insert(i, String.valueOf(x));
      }
      System.out.println(buff.toString());
      numbers.add(buff.toString());
    }
    String max = numbers.remove(numbers.size() - 1);
    for (String num : numbers) {
      for (int i = 0; i < num.length(); i++) {
        if (positive) {
          if (Integer.valueOf(num.charAt(i)) < Integer.valueOf(max.charAt(i))) {
            max = num;
          }
        } else {
          if (Integer.valueOf(num.charAt(i)) > Integer.valueOf(max.charAt(i))) {
            max = num;
          }
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String n = "123";
    int x = 3;
    Leetcode5773 obj = new Leetcode5773();
    System.out.println(obj.maxValue(n, x));
  }
}
