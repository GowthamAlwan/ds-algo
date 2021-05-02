package com.gowthamalwan.algorithms.hashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> sums = new HashSet<>();
    int sumOfSquares = n;
    while (!sums.contains(sumOfSquares)) {
      sums.add(sumOfSquares);
      sumOfSquares = sumOfSquares(sumOfSquares);
      if (sumOfSquares == 1) {
        return true;
      }
    }
    return false;
  }

  public int sumOfSquares(int n) {
    int sum = 0;
    while (n != 0) {
      int num = n % 10;
      sum += num * num;
      n = n / 10;
    }
    System.out.println(sum);
    return sum;
  }
  public static void main(String[] args) {
    HappyNumber obj = new HappyNumber();
    System.out.println(obj.isHappy(18));
  }
}