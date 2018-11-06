//
// Created by Joshua.Cao, 2018/11/03
// 
// https://leetcode.com/problems/partition-array-into-disjoint-intervals/
//

/**
 * Given an array A, partition it into two (contiguous) subarrays left and 
 * right so that:
 *   1. Every element in left is less than or equal to every element in right.
 *   2. left and right are non-empty.
 *   3. left has the smallest possible size.
 * Return the length of left after such a partitioning.  It is guaranteed that 
 * such a partitioning exists.
 * 
 * Example 1:
 *   Input: [5,0,3,8,6]
 *   Output: 3
 *   Explanation: left = [5,0,3], right = [8,6]
 * 
 * Example 2:
 *   Input: [1,1,1,0,6,12]
 *   Output: 4
 *   Explanation: left = [1,1,1,0], right = [6,12]
 *  
 * 
 * Note:
 *   1. 2 <= A.length <= 30000
 *   2. 0 <= A[i] <= 10^6
 *   3. It is guaranteed there is at least one way to partition A as described.
 */
public class PartitionArray {
  // Accepted, beats 100%
  public int partitionDisjoint(int[] A) {
    if (A == null || A.length <= 0) return 0;
    int right = 0, high = A[0], maximum = A[0];
    for (int i = 1; i < A.length; i++) {
      if (A[i] < high) {
        right = i;
        high = maximum;
      }
      if (A[i] > maximum) {
        maximum = A[i];
      }
    }
    return right + 1;
  }

  public static void main(String[] args) {
    PartitionArray obj = new PartitionArray();
    int[] input_1 = {5,0,3,8,6};
    System.out.println(obj.partitionDisjoint(input_1));
    int[] input_2 = {1,1,1,0,6,12};
    System.out.println(obj.partitionDisjoint(input_2));
    int[] input_3 = {29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88};
    System.out.println(obj.partitionDisjoint(input_3));
  }
}