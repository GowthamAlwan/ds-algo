import java.util.*;

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