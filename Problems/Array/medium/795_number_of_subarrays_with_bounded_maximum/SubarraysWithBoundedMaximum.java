//
// Created by Joshua.Cao, 2018/11/03
// 
// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
//
import java.util.Stack;

/*
 * We are given an array A of positive integers, and two positive integers L 
 * and R (L <= R).
 * 
 * Return the number of (contiguous, non-empty) subarrays such that the value 
 * of the maximum array element in that subarray is at least L and at most R.
 * 
 * Example :
 *   Input: A = [2, 1, 4, 3], L = 2, R = 3
 *   Output: 3
 *   Explanation: There are three subarrays that meet the requirements: 
 *   [2], [2, 1], [3].
 * 
 * Note:
 *   1. L, R  and A[i] will be an integer in the range [0, 10^9].
 *   2. The length of A will be in the range of [1, 50000].
 */
public class SubarraysWithBoundedMaximum {
  /*
   * In every iteration, we add the number of valid subarrays that ends at the 
   * current element.
   * 
   * For example, for input A = [0, 1, 2, -1], L = 2, R = 3:
   *   1. for 0, no valid subarray ends at 0;
   *   2. for 1, no valid subarray ends at 1;
   *   3. for 2, three valid subarrays end at 2, which are [0,1,2], [1,2], [2];
   *   4. for -1, the number of valid subarrays is the same as 2, which 
   *   are [0, 1, 2, -1], [1, 2, -1], [2, -1];
  */
  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int n = A.length, counter = 0, left = 0, temp = 0;
    for (int i = 0; i < n; i++) {
      if (A[i] >= L && A[i] <= R) {
        temp = i - left + 1;
        counter += temp;
      } else if (A[i] < L){
        counter += temp;
      } else {
        temp = 0;
        left = i + 1;
      }
    }
    return counter;
  }

  // Accepted, beats 1.98%
  public int numSubarrayBoundedMax_2(int[] A, int L, int R) {
    int n = A.length, counter = 0;
    int[][] ranges = new int[n][2];
    Stack<Integer> stack = new Stack<>();
    
    stack.push(-1);
    for (int i = 0; i < n; i++) {
      if (A[i] < L || A[i] > R) {
        stack.push(i);
        continue;
      }
      while (stack.peek() != -1 && A[stack.peek()] <= A[i]) {
        stack.pop();
      }
      ranges[i][0] = stack.peek() + 1;
      stack.push(i);
    }
    stack.clear();
    stack.push(n);
    for (int i = n - 1; i >= 0; i--) {
      if (A[i] < L || A[i] > R) {
        stack.push(i);
        continue;
      }
      while(stack.peek() != n && A[stack.peek()] < A[i]) {
        stack.pop();
      }
      ranges[i][1] = stack.peek() - 1;
      stack.push(i);
      int left = ranges[i][0], right = ranges[i][1];
      counter += (i - left + 1) * (right - i + 1);
    }
    // for (int i = 0; i < n; i++) {
    //   System.out.format("[%d, %d]\t", ranges[i][0], ranges[i][1]);
    // }
    return counter;
  }

  public static void main(String[] args) {
    SubarraysWithBoundedMaximum obj = new SubarraysWithBoundedMaximum();
    int[] input_1 = {2, 1, 4, 3};
    System.out.println(obj.numSubarrayBoundedMax(input_1, 2, 3));
    int[] input_2 = {73,55,36,5,55,14,9,7,72,52};
    System.out.println(obj.numSubarrayBoundedMax(input_2, 32, 69));
    int[] input_3 = {0, 1, 3, 2, 0, 0, 0};
    System.out.println(obj.numSubarrayBoundedMax_2(input_3, 2, 3));
  }
}