//
// Created by Joshua.Cao, 2018/11/08
// 
// https://leetcode.com/problems/first-missing-positive/
//
import java.util.Arrays;

/*
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 *   Input: [1,2,0]
 *   Output: 3
 * 
 * Example 2:
 *   Input: [3,4,-1,1]
 *   Output: 2
 * 
 * Example 3:
 *   Input: [7,8,9,11,12]
 *   Output: 1
 *
 * Note:
 *   Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
  // Accepted, beats 100.00% with O(n) time
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] < 0 || nums[i] > n) nums[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0) continue;
      int index = nums[i];
      while (nums[index - 1] >= 0) {
        int temp = nums[index - 1];
        nums[index - 1] = -1;
        if (temp == 0) break;
        index = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] != -1) return i + 1;
    }

    return n + 1;
  }

  // Accepted, beats 86.69% with O(n) time
  public int firstMissingPositive_2(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] < 0 || nums[i] > n) nums[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) continue;
      int v = Math.abs(nums[i]);
      if (v > n) continue;
      if (nums[v - 1] > 0) {
        nums[v - 1] = -nums[v - 1];
      } else if (nums[v - 1] == 0) {
        nums[v - 1] = -n -1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] >= 0) return i + 1;
    }
    return n + 1;
  }

  // Accepted, beats 100.00% with O(nlg(n)) time
  public int firstMissingPositive_3(int[] nums) {
    if (nums.length <= 0) return 1;
    Arrays.sort(nums);
    if (nums[0] > 1) return 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= 0) continue;
      if (nums[i - 1] <= 0) {
        if (nums[i] != 1) return 1;
        continue;
      }
      if (nums[i] > nums[i - 1] + 1) {
        return nums[i - 1] + 1;
      }
    }

    return nums[nums.length - 1] + 1;
  }

  private void test(int[] nums) {
    System.out.println(firstMissingPositive(nums));
  }

  public static void main(String[] args) {
    FirstMissingPositive obj = new FirstMissingPositive();
    obj.test(new int[]{});
    obj.test(new int[]{1, 2, 0});
    obj.test(new int[]{0, 1, 2});
    obj.test(new int[]{3, 4, -1, 1});
    obj.test(new int[]{3, 4, 0, 2});
    obj.test(new int[]{7, 8, 9, 11, 12});
  }
}