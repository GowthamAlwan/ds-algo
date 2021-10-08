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
    List<Integer> ans = new ArrayList<>();
    int m = matrix.length;
    if (m == 0) return ans;
    int n = matrix[0].length;
    if (n == 0) return ans;

    int[][] dirMatrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[] steps = {n, m - 1};
    int dir = 0;
    int row = 0, col = -1;

    while (steps[dir % 2] != 0) {
      for (int i = 0; i < steps[dir % 2]; i++) {
        row += dirMatrix[dir][0];
        col += dirMatrix[dir][1];
        ans.add(matrix[row][col]);
      }

      steps[dir % 2] -= 1;
      dir = (dir + 1) % 4;
    }

    return ans;
  }

  public static List<Integer> spiralOrder1(int[][] matrix) {
    int m = matrix.length;
    int n = (m > 0) ? matrix[0].length : 0;
    int left = 0;
    int top = 0;
    int right = n - 1;
    int bottom = m - 1;

    List<Integer> ans = new ArrayList<>(Collections.nCopies(m*n, 0));

    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        ans.add(matrix[top][i]);
      }
      top++;

      for (int i = top; i <= bottom; i++) {
        ans.add(matrix[i][right]);
      }
      right--;

      if (left > right) {
        break;
      }

      for (int i = right; i >= left; i--) {
        ans.add(matrix[bottom][i]);
      }
      bottom--;

      for (int i = bottom; i >= top; i--) {
        ans.add(matrix[i][left]);
      }
      left++;
    }

    return ans;
  }
}