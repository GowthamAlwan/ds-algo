/**
 * Diagonal Traverse
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order
 * as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraversal {
  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5}, {7, 8, 9}};
    int[] result = findDiagonalOrder(matrix);
    for (int num : result) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static int[] findDiagonalOrder(int[][] matrix) {
    int rl = 0;
    int m = matrix.length;
    int n = 0;
    for (int i = 0; i < m; ++i) {
      int len = matrix[i].length;
      rl += len;
      if (n < len) {
        n = len;
      }
    }
    int[] result = new int[rl];

    int row = 0, col = 0, r = 0;
    boolean dir = true;
    while(row < m && col < n) {
      if (dir) {
        while (row > 0 && col < n - 1) {
          result[r++] = matrix[row--][col++];
        }
        result[r++] = matrix[row][col];
        if (col == n - 1) {
          row++;
        } else {
          col++;
        }
      } else {
        while(row < m - 1 && col > 0) {
          result[r++] = matrix[row++][col--];
        }
        result[r++] = matrix[row][col];
        if (row == m - 1) {
          col++;
        } else {
          row++;
        }
      }
      dir = !dir;
    }
    return result;
  }
}