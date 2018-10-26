//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/two-sum/description/
 */

import java.util.HashMap;
import java.util.Map;
public class TwoSum {
  
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int result[] = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int expected = target - nums[i];
      if (map.get(expected) != null) {
        return new int[]{map.get(expected), i};
      }
      map.put(nums[i], i);
    }
    return result;
  }

  public static void main(String[] args) {

  }
}