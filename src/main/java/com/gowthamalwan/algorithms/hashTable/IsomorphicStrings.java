package com.gowthamalwan.algorithms.hashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    return check(s, t) && check(s, t);
  }

  public boolean check(String s, String t) {
    Map<Character, Character> charMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if (charMap.containsKey(sChar) && !charMap.get(sChar).equals(tChar)) {
        return false;
      } else {
        charMap.put(sChar, tChar);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    IsomorphicStrings obj = new IsomorphicStrings();
    System.out.println(obj.isIsomorphic("foo", "bar"));
  }
}