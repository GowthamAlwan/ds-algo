package com.gowthamalwan.algorithms.hashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
  public int firstUniqChar(String s) {
    if (s == null) return -1;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char character = s.charAt(i);
      if (map.containsKey(character)) {
        Integer occurence = map.get(character);
        map.put(character, ++occurence);
      } else {
        map.put(character, 1);
      }
    }
    for (int i = 0; i < s.length(); i++) {
      char character = s.charAt(i);
      if (map.containsKey(character) && map.get(character) == 1) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    FirstUniqueChar obj = new FirstUniqueChar();
    System.out.println(obj.firstUniqChar(""));
  }
}
