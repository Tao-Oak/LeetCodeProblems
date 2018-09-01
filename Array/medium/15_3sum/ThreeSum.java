//
// Created by CaoTao, 2018/08/20
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/3sum/description/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      Map<Integer, Integer> twoSumMap = map.get(nums[i]);
      if (twoSumMap == null) {
        twoSumMap = new HashMap<Integer, Integer>();
        map.put(nums[i], twoSumMap);
      } else {
        continue;
      }
      int target = -nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int expected = target - nums[j];
        if (twoSumMap.get(expected) != null) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(expected);
          temp.add(nums[j]);
          result.add(temp);
          continue;
        }
        twoSumMap.put(nums[j], j);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ThreeSum obj = new ThreeSum();
    List<List<Integer>> result = obj.threeSum(new int[]{-1,0,1,2,-1,-4});
    
    for (List<Integer> next: result) {
      System.out.println(next.toString());
    }
  }
}