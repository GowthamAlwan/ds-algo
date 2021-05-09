package com.gowthamalwan.algorithms.hashTable;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
  public int numJewelsInStones(String jewels, String stones) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : jewels.toCharArray()) {
      map.put(c, 0);
    }
    for (char c : stones.toCharArray()) {
      if (map.containsKey(c)) {
        Integer i = map.get(c);
        map.put(c, i + 1);
      }
    }
    return map.values().stream().reduce(0, Integer::sum);
  }

  public static void main(String[] args) {
    JewelsAndStones obj = new JewelsAndStones();
    System.out.println(obj.numJewelsInStones("aA", "abcdAAajk"));
  }
}
