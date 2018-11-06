//
// Created by Joshua.Cao, 2018/11/03
// 
// https://leetcode.com/problems/rle-iterator/
//
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Write an iterator that iterates through a run-length encoded sequence.
 * 
 * The iterator is initialized by RLEIterator(int[] A), where A is a run-length 
 * encoding of some sequence.  More specifically, for all even i, A[i] tells us 
 * the number of times that the non-negative integer value A[i+1] is repeated 
 * in the sequence.
 * 
 * The iterator supports one function: next(int n), which exhausts the next n 
 * elements (n >= 1) and returns the last element exhausted in this way.  If 
 * there is no element left to exhaust, next returns -1 instead.
 * 
 * For example, we start with A = [3,8,0,9,2,5], which is a run-length encoding 
 * of the sequence [8,8,8,5,5].  This is because the sequence can be read as 
 * "three eights, zero nines, two fives".
 * 
 * Example 1:
 *   Input:
 *     ["RLEIterator","next","next","next","next"],
 *     [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
 *   Output: [null,8,8,5,-1]
 *   Explanation: RLEIterator is initialized with RLEIterator([3,8,0,9,2,5]). 
 *   This maps to the sequence [8,8,8,5,5]. RLEIterator.next is then called 4 
 *   times:
 *     .next(2) exhausts 2 terms of the sequence, returning 8.  The remaining 
 *     sequence is now [8, 5, 5].
 *     
 *     .next(1) exhausts 1 term of the sequence, returning 8.  The remaining 
 *     sequence is now [5, 5].
 *     
 *     .next(1) exhausts 1 term of the sequence, returning 5.  The remaining 
 *     sequence is now [5].
 *     
 *     .next(2) exhausts 2 terms, returning -1.  This is because the first term 
 *     exhausted was 5, but the second term did not exist.  Since the last term 
 *     exhausted does not exist, we return -1.
 * 
 * Note:
 *   1. 0 <= A.length <= 1000
 *   2. A.length is an even integer.
 *   3. 0 <= A[i] <= 10^9
 *   4. There are at most 1000 calls to RLEIterator.next(int n) per test case.
 *   5. Each call to RLEIterator.next(int n) will have 1 <= n <= 10^9.
 */
// Accepted, beats 30.97%
public class RLEIterator {
  int[] input;
  int iterator, remain, length;
  public RLEIterator(int[] A) {
    input = A;
    iterator = 0;
    length = A.length;
    remain = A[iterator];
  }
  
  public int next(int n) {
    // System.out.format("itor: %d, len: %d\n", iterator, length);
    if (iterator >= length) return -1;

    if (remain > n) {
      remain -= n;
      return input[iterator + 1];
    } else if (remain == n) {
      int result = input[iterator + 1];
      iterator += 2;
      if (iterator < length) {
        remain = input[iterator];
      } else {
        remain = 0;
      }
      return result;
    } else {
      n -= remain;
      iterator += 2;
      if (iterator >= length) return -1;
      remain = input[iterator];
      return next(n);
    }
  }

  private static void test(int[] input, int[] task) {
    RLEIterator obj = new RLEIterator(input);
    for (int i = 0; i < task.length; i++) {
      System.out.print(obj.next(task[i]) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] input_1 = {3,8,0,9,2,5};
    int[] task_1 = {2, 1, 1, 2};
    RLEIterator.test(input_1, task_1);

    int[] input_2 = {
      923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82
    };
    int[] task_2 = {
      612783106,486444202,630147341,845077576,243035623,731489221,117134294,220460537,794582972,332536150,815913097,100607521,146358489,697670641,45234068,573866037,519323635,27431940,16279485,203970
    };
    RLEIterator.test(input_2, task_2);

    int[] input_3 = {
      635,606,576,391,370,981,36,21,961,185,124,210,801,937,22,426,101,260,221,647,350,180,504,39,101,989,199,358,732,839,919,169,673,967,58,676,846,342,250,597,442,174,472,410,569,509,311,357,838,251
    };
    int[] task_3 = {
      5039,62,3640,671,67,395,262,839,74,43,42,77,13,6,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
    };
    RLEIterator.test(input_3, task_3);
  }
}