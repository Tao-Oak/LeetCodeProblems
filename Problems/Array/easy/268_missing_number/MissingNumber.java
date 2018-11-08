//
// Created by Joshua.Cao, 2018/11/08
// 
// https://leetcode.com/problems/missing-number/
//

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * Example 1:
 *   Input: [3,0,1]
 *   Output: 2
 * 
 * Example 2:
 *   Input: [9,6,4,2,3,5,7,0,1]
 *   Output: 8
 * 
 * Note:
 *   Your algorithm should run in linear runtime complexity. Could you implement
 *   it using only constant extra space complexity?
 */
public class MissingNumber {
  // Accepted,  beats 100%
  public int missingNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result += i - nums[i] + 1;
    }
    return result;
  }

  // Accepted,  beats 69.00%
  public int missingNumber_2(int[] nums) {
    // a ^ b ^ b = a
    int result = nums.length;
    for (int i = 0; i < nums.length; i++) {
      result ^= i ^ nums[i];
    }
    return result;
  }

  private void test(int[] nums) {
    System.out.println(missingNumber(nums));
  }

  public static void main(String[] args) {
    MissingNumber obj = new MissingNumber();
    obj.test(new int[]{3,0,1});
    obj.test(new int[]{9,6,4,2,3,5,7,0,1});
    obj.test(new int[]{});
  }
}