//
// Created by CaoTao, 2018/09/16
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/combination-sum/description/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    backtrack(result, tempList, candidates, target, 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> templist, int nums[], int remain, int start) {
    for (int i = start; i < nums.length; i++) {
      if (nums[i] > remain) { break; }
      if (nums[i] == remain) {
        templist.add(nums[i]);
        result.add(new ArrayList(templist));
        templist.remove(templist.size() - 1);
        break;
      }
      templist.add(nums[i]);
      backtrack(result, templist, nums, remain - nums[i], i);
      templist.remove(templist.size() - 1);
    }
  }

  public static void main(String[] args) {
    CombinationSum obj = new CombinationSum();
    int[] nums = {2,3,6,7};
    List<List<Integer>> result = obj.combinationSum(nums, 7);
    System.out.println(result);

    int[] nums2 = {2,3,5};
    List<List<Integer>> result2 = obj.combinationSum(nums2, 8);
    System.out.println(result2);
  }
}