//
// Created by Joshua.Cao, 2018/10/29
//
// https://leetcode.com/problems/global-and-local-inversions/
//

/*
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 * 
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N 
 * and A[i] > A[j].
 * 
 * The number of local inversions is the number of i with 0 <= i < N and 
 * A[i] > A[i+1].
 * 
 * Return true if and only if the number of global inversions is equal to the 
 * number of local inversions.
 * 
 * Example 1:
 *   Input: A = [1,0,2]
 *   Output: true
 *   Explanation: There is 1 global inversion, and 1 local inversion.
 * 
 * Example 2:
 *   Input: A = [1,2,0]
 *   Output: false
 *   Explanation: There are 2 global inversions, and 1 local inversion.
 * 
 * Note:
 *   A will be a permutation of [0, 1, ..., A.length - 1].
 *   A will have length in range [1, 5000].
 *   The time limit for this problem has been reduced.
 */
public class GlobalAndLocalInversions {
  /*
   * To meet the requirements of ideal permutation, for any given index i with
   * 0 <= i < N, there are two possibile solutions:
   * 
   *  1. There is no such index j with i < j < N that meets A[i] > A[j];
   * 
   *  2. There is exactly one index j with i < j < N that meets A[i] > A[j].
   *     And given that the requirement of local inversions, j must be equals
   *     to i + 1;
   * 
   * So, for any given index i with 0 <= i < N,
   *  1. A[i] = i or
   *  2. A[i] = i + 1 and A[i + 1] = i
   */
  // Accepted, beats 72.29%
  public boolean isIdealPermutation(int[] A) {
    int i = 0;
    while (i < A.length) {
      if (A[i] == i + 1 && A[i + 1] == i) {
        i++;
      } else if (A[i] != i) {
        return false;
      }
      i++;
    }
    return true;
  }

  // Time Limit Exceeded
  public boolean isIdealPermutation_2(int[] A) {
    int gCounter = 0, lCounter = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (A[i] > A[j]) gCounter++;
        if (j == i + 1 && A[i] > A[j]) lCounter++;
      }
    }
    return gCounter == lCounter;
  }

  public static void main(String[] args) {
    GlobalAndLocalInversions obj = new GlobalAndLocalInversions();
    int[] input_1 = {1,0,2};
    System.out.println(obj.isIdealPermutation(input_1));
    int[] input_2 = {1,2,0};
    System.out.println(obj.isIdealPermutation(input_2));
  }
}