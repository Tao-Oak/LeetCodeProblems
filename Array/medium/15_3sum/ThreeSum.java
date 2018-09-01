//
// Created by CaoTao, 2018/08/20
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/3sum/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ThreeSum {
  public List<List<Integer>> threeSum_failed(int[] nums) {
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

  public int partition (int[] nums, int low, int high) {
    if (low >= high) return high;
    int pivot = nums[low];
    int left = low + 1, right = high;
    while (left <= right) {
      if (nums[right] >= pivot) {
        right--;
        continue;
      }
      nums[left - 1] = nums[right];
      nums[right] = nums[left];
      nums[left] = pivot;
      left++;
    }
    return left - 1;
  }

  public void quickSort(int[] nums, int low, int high) {
    if (low >= high) return;
    int medium = partition(nums, low, high);
    quickSort(nums, low, medium - 1);
    quickSort(nums, medium + 1, high);
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 3) return result;
    quickSort(nums, 0, nums.length - 1);
    // Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        if (left > i + 1 && nums[left - 1] == nums[left]) {
          left++;
          continue;
        }
        int sum = nums[left] + nums[right];
        if (sum > -nums[i]) {
          right--;
        } else if (sum < -nums[i]){
          left++;
        } else {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          right--;
          left++;
        }
      }
    }

    return result;
  }

  public List<List<Integer>> threeSum_2 (int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 3) return result;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum > -nums[i]) {
          right--;
          while (right > left && nums[right] == nums[right + 1]) {
            right--;
          }
        } else if (sum < -nums[i]) {
          left++;
          while (left < right && nums[left - 1] == nums[left]) {
            left++;
          }
        } else {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          right--;
          left++;
          while (left < right && nums[left - 1] == nums[left]) {
            left++;
          }
          while (right > left && nums[right] == nums[right + 1]) {
            right--;
          }
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ThreeSum obj = new ThreeSum();
    List<List<Integer>> result = obj.threeSum_2(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
    
    for (List<Integer> next: result) {
      System.out.println(next.toString());
    }
  }
}

// [-5, 1, 4]
// [-4, 0, 4]
// [-4, 1, 3]
// [-2, -2, 4]
// [-2, 1, 1]
// [0, 0, 0]