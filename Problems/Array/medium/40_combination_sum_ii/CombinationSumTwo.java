//
// Created by CaoTao, 2018/09/16
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    System.out.println(Arrays.toString(candidates));
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    backtrack_2(result, temp, candidates, 0, target);
    return result;
  }

  public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start, int remain) {
    for (int i = start; i < nums.length; i++) {
      if (nums[i] > remain) {
        break;
      }
      if (nums[i] == remain) {
        temp.add(nums[i]);
        result.add(new ArrayList<>(temp));
        temp.remove(temp.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
          i++;
        }
        break;
      }
      temp.add(nums[i]);
      backtrack(result, temp, nums, i + 1, remain - nums[i]);
      temp.remove(temp.size() - 1);

      while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        i++;
      }
    }
  }

  public void backtrack_2(List<List<Integer>> result, List<Integer> temp, int[] nums, int start, int remain) {
    if (remain < 0) return;
    if (remain == 0) {
      result.add(new ArrayList<>(temp));
      return;
    } 
    
    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      backtrack_2(result, temp, nums, i + 1, remain - nums[i]);
      temp.remove(temp.size() - 1);
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        i++;
      }
    }
  }

  public static void main(String[] args) {
    CombinationSumTwo obj = new CombinationSumTwo();

    int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
    List<List<Integer>> result = obj.combinationSum2(nums, 8);
    System.out.println(result);
  }
}