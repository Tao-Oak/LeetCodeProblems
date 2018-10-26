//
// Created by CaoTao, 2018/09/01
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/4sum/description/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int length = nums.length;
    if (length < 3) return result;
    Arrays.sort(nums);
    // System.out.println("sorted nums: " + Arrays.toString(nums));

    for (int i = 0; i < length - 3; i++) {
      // if (nums[i] > target) break;
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int threeSumTarget = target - nums[i];
      // System.out.println("threeSumTarget: " + threeSumTarget);
      for (int j = i + 1; j < length - 2; j++) {
        //if (nums[j] > threeSumTarget || nums[i] + nums[j] > target) break;
        if (j > i + 1 && nums[j - 1] == nums[j]) {
          continue;
        }
        int twoSumTarget = threeSumTarget - nums[j];
        // System.out.println("twoSumTarget: " + twoSumTarget);
        int left = j + 1, right = length - 1;
        while (left < right) {
          if (left > j + 1 && nums[left - 1] == nums[left]) {
            left++;
            continue;
          }
          int sum = nums[left] + nums[right];
          if (sum > twoSumTarget) {
            right--;
          } else if (sum < twoSumTarget) {
            left++;
          } else {
            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            right--;
            left++;
          }
        }
      }
    }

    return result;
  }

  void printResult(List<List<Integer>> result) {
    System.out.println("result.size(): " + result.size());
    for (List<Integer> next: result) {
      System.out.println(next.toString());
    }
  }

  public static void main(String[] args) {
    FourSum obj = new FourSum();
    List<List<Integer>> result1 = obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    obj.printResult(result1);

    List<List<Integer>> result2 = obj.fourSum(new int[]{0, 0, 0, 0}, 0);
    obj.printResult(result2);

    List<List<Integer>> result3 = obj.fourSum(new int[]{-1,0,1,2,-1,-4}, -1);
    obj.printResult(result3);

    List<List<Integer>> result4 = obj.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
    obj.printResult(result4);
  }
}