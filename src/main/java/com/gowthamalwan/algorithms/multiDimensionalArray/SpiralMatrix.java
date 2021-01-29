package com.gowthamalwan.algorithms.multiDimensionalArray;

import java.util.*;

/**
 * Spiral Matrix
 * <p>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    List<Integer> result = spiralOrder(matrix);
    for (int num : result) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return new ArrayList<>();

    int m = matrix[0].length;
    int n = matrix.length;
    List<Integer> result = new ArrayList<>(Collections.nCopies(m*n, 0));
    int l = 0, r = m - 1, t = 0, b = n - 1;
    int p = 0;
    
    while(p < result.size()) {
      for (int i = l; i < r; ++i) {
        result.set(p++, matrix[t][i]);
      }
      if (p >= result.size())
        break;
      result.set(p++, matrix[t++][r]);

      for (int i = t; i < b; ++i) {
        result.set(p++, matrix[i][r]);
      }
      if (p >= result.size())
        break;
      result.set(p++, matrix[b][r--]);

      for (int i = r; i > l; --i) {
        result.set(p++, matrix[b][i]);
      }
      if (p >= result.size())
        break;
      result.set(p++, matrix[b--][l]);

      for (int i = b; i > t; --i) {
        result.set(p++, matrix[i][l]);
      }
      if (p >= result.size())
        break;
      result.set(p++, matrix[t][l++]);
    }

    return result;
  }
}