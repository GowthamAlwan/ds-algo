/**
 * Sort Array By Parity
 * <p>
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
class SegregateEven {

  public static void rearrange(int[] arr) {
    int len = arr.length;
    int j = 0;
    for (int i = 0; i < len; i++) {
      if (arr[i] % 2 == 0) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        j++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {12, 34, 45, 9, 8, 90, 3};
    rearrange(arr);
    for (int j : arr) System.out.print(j + " ");
  }
}