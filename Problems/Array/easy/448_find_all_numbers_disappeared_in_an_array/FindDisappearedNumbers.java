//
// Created by Joshua.Cao, 2018/11/08
// 
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//
import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some 
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the 
 * returned list does not count as extra space.
 * 
 * Example:
 *   Input: [4,3,2,7,8,2,3,1]
 *   Output: [5,6]
*/
public class FindDisappearedNumbers {
  // Accepted, beats 35.51%
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int n = Math.abs(nums[i]) - 1;
      if (nums[n] > 0) nums[n] = -nums[n];
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) result.add(i + 1);
    }
    return result;
  }

  // Accepted, beats 42.24%
  public List<Integer> findDisappearedNumbers_2(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == -1) continue;
      int index = nums[i] - 1;
      while(nums[index] != -1) {
        int temp = nums[index] - 1;
        nums[index] = -1;
        index = temp;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) result.add(i + 1);
    }
    return result;
  }

  private void test(int[] nums) {
    System.out.println(findDisappearedNumbers(nums));
  }

  public static void main(String[] args) {
    FindDisappearedNumbers obj = new FindDisappearedNumbers();
    obj.test(new int[]{4,3,2,7,8,2,3,1});
  }
}