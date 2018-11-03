//
// Created by Joshua.Cao, 2018/10/27
//
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
//
// Similar problems:
//   https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLengthOfRepeatedSubarray {
  public int findLength(int[] A, int[] B) {
    int maxLength = 0;
    return maxLength;
  }

  // Accepted, beats 49.68%
  public int findLength_2(int[] A, int[] B) {
    int m = A.length, n = B.length;
    if (m == 0 || n == 0) return 0;
    int[][] dp = new int[m + 1][n + 1];
    int maxLength = 0;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = A[i - 1] == B[j - 1] ? 1 + dp[i - 1][j - 1] : 0;
        if (dp[i][j] > maxLength) maxLength = dp[i][j];
      }
    }

    return maxLength;
  }

  // Accepted, beats 3.53%
  public int findLength_3(int[] A, int[] B) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      List<Integer> list;
      if (map.containsKey(B[i])) {
        list = map.get(B[i]);
      } else {
        list = new ArrayList<>();
      }
      list.add(i);
      map.put(B[i], list);
    }

    int maxLength = 0;
    for (int i = 0; i < A.length - maxLength; i++) {
      if (map.containsKey(A[i])) {
        List<Integer> list = map.get(A[i]);
        for(Integer index: list) {
          if (index < B.length - maxLength) {
            int counter = 0;
            while (i + counter < A.length && index + counter < B.length) {
              if (A[i + counter] == B[index + counter]) {
                counter++;
              } else {
                break;
              }
            }
            if (counter > maxLength) maxLength = counter;
          }
        }
      }
    }
    return maxLength;
  }


  // Accepted, beats 6.98%
  public int findLength_4(int[] A, int[] B) {
    int maxLength = 0;
    for (int i = 0; i < A.length - maxLength; i++) {
      for (int j = 0; j < B.length - maxLength; j++) {
        if (A[i] == B[j]) {
          int counter = 1;
          while (i + counter < A.length && j + counter < B.length) {
            if (A[i + counter] == B[j + counter]) {
              counter++;
            } else {
              break;
            }
          }
          if (counter > maxLength) maxLength = counter;
        }
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    MaximumLengthOfRepeatedSubarray obj = new MaximumLengthOfRepeatedSubarray();
    int[] A = {1,2,3,2,1};
    int[] B = {3,2,1,4,7};
    System.out.println(obj.findLength_2(A, B));
  }
}