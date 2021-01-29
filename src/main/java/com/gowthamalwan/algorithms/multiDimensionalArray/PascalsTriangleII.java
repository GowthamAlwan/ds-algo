package com.gowthamalwan.algorithms.multiDimensionalArray;

import java.util.*;

/**
 * Pascal's Triangle II
 * <p>
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 * Notice that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 * <p>
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * <p>
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * <p>
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * <p>
 * Constraints:
 * 0 <= rowIndex <= 33
 */
public class PascalsTriangleII {
  public static void main(String[] args) {
    int rowIndex = 0;
    List<Integer> row = getRow(rowIndex);
    System.out.println(row);
  }

  public static List<Integer> getRow(int rowIndex) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i <= rowIndex; ++i) {
      List<Integer> row = initRow(i + 1);
      if (i >= 2) {
        List<Integer> previousRow = triangle.get(i - 1);
        for (int j = 1; j < i; ++j) {
          row.set(j, previousRow.get(j - 1) + previousRow.get(j));
        }
      }
      triangle.add(row);
    }
    return triangle.get(rowIndex);
  }

  public static List<Integer> initRow(int length) {
    List<Integer> row = new ArrayList<>(Collections.nCopies(length, 0));
    row.set(0, 1);
    row.set(length - 1, 1);
    return row;
  }
}