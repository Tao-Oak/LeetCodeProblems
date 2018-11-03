//
// Created by Joshua.Cao, 2018/11/03
// 
// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
//
// Similar problems:
//   https://leetcode.com/problems/maximum-length-of-repeated-subarray/
//
import java.util.HashMap;
import java.util.Map;

/*
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if: n >= 3
 *    X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * 
 * Given a strictly increasing array A of positive integers forming a sequence, 
 * find the length of the longest fibonacci-like subsequence of A.  If one does 
 * not exist, return 0.
 * 
 * (Recall that a subsequence is derived from another sequence A by deleting 
 * any number of elements (including none) from A, without changing the order 
 * of the remaining elements.  For example, [3, 5, 8] is a subsequence of 
 * [3, 4, 5, 6, 7, 8].)
 * 
 * Example 1:
 *   Input: [1,2,3,4,5,6,7,8]
 *   Output: 5
 *   Explanation:
 *   The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * 
 * Example 2:
 *   Input: [1,3,7,11,12,14,18]
 *   Output: 3
 *   Explanation:
 *   The longest subsequence that is fibonacci-like:
 *   [1,11,12], [3,11,14] or [7,11,18].
 *  
 * Note:
 * 1. 3 <= A.length <= 1000
 * 2. 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * 3. The time limit has been reduced by 50% for submissions in Java, C, and C++
 */
public class LongestFibonacciSequence {
  // Accepted, beats 99.64%
  public int lenLongestFibSubseq(int[] A) {
    int n = A.length, result = 0;
    int[][] dp = new int[n][n];
    for (int i = 1; i < n; i++) {
      int left = 0, right = i - 1;
      while (left < right) {
        int sum = A[left] + A[right];
        if (sum < A[i]) {
          left++;
        } else if (sum > A[i]) {
          right--;
        } else {
          dp[right][i] = dp[left][right] + 1;
          result = Math.max(dp[right][i], result);
          left++;
          right--;
        }
      }
    }
    return result == 0 ? result : result + 2;
  }

  // Accepted, beats 79.28%
  public int lenLongestFibSubseq_2(int[] A) {
    int n = A.length, maxLength = 0;
    int[][] dp = new int[n][n];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) { map.put(A[i], i); }
    
    for (int i = n - 3; i >= 0; i--) {
      for (int j = n - 2; j > i; j--) {
        int sum = A[i] + A[j];
        if (map.containsKey(sum)) {
          dp[i][j] = dp[j][map.get(sum)] + 1;
          maxLength = Math.max(maxLength, dp[i][j]);
        }
      }
    }
    return maxLength == 0 ? maxLength : maxLength + 2;
  }

  // Accepted, beats 45.06%
  public int lenLongestFibSubseq_3(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      map.put(A[i], i);
    }
    int maxLength = 0;
    for (int i = 0; i < A.length - 3; i++) {
      for (int j = i + 1; j < A.length - 2; j++) {
        int length = calculateLength(map, A[i], A[j]);
        if (length > maxLength) maxLength = length;
      }
    }
    return maxLength;
  }

  private int calculateLength(Map<Integer, Integer> map, int i, int j) {
    int length = 0;
    int sum = i + j;
    while (map.containsKey(sum)) {
      length++;
      i = j;
      j = sum;
      sum = i + j;
    }
    return length == 0 ? length : length + 2;
  }

  public static void main(String[] args) {
    LongestFibonacciSequence obj = new LongestFibonacciSequence();
    int[] input_1 = {1,2,3,4,5,6,7,8};
    int[] input_2 = {1,3,7,11,12,14,18};
    System.out.println(obj.lenLongestFibSubseq(input_1));
    System.out.println(obj.lenLongestFibSubseq(input_2));
  }
}