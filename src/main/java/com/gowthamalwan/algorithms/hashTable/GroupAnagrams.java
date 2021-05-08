package com.gowthamalwan.algorithms.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortedStr = new String(chars);
      if (!map.containsKey(sortedStr)) {
        map.put(sortedStr, new ArrayList<>());
      }
      map.get(sortedStr).add(str);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    GroupAnagrams obj = new GroupAnagrams();
    String[] strs = {"hello", "olleh", "gowtham"};
    List<List<String>> result = obj.groupAnagrams(strs);
    System.out.println("{");
    for (List<String> lists : result) {
      System.out.println("[");
      for (String s : lists) {
        System.out.println(s);
      }
      System.out.println("]");
    }
    System.out.println("}");
  }
}
