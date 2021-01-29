package com.gowthamalwan.algorithms.multiDimensionalArray;

import java.util.*;

/**
 * Pascal's Triangle
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * Input: 5
 * Output:
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
  public static void main(String[] args) {
    List<List<Integer>> triangle = generate(10);
    for (List<Integer> row : triangle) {
      for (Integer i : row) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i < numRows; ++i) {
      List<Integer> row = initRow(i + 1);
      if (i >= 2) {
        List<Integer> previousRow = triangle.get(i - 1);
        for (int j = 1; j < i; ++j) {
          row.set(j, previousRow.get(j - 1) + previousRow.get(j));
        }
      }
      triangle.add(row);
    }
    return triangle;
  }

  public static List<Integer> initRow(int length) {
    List<Integer> row = new ArrayList<>(Collections.nCopies(length, 0));
    row.set(0, 1);
    row.set(length - 1, 1);
    return row;
  }
}