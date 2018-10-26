//
// Created by CaoTao, 2018/09/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class RotatedSortedArray {
  public int search(int[] nums, int target) {
    if (nums.length <= 0) return -1;
    int left = 0, right = nums.length - 1;
    return helper(nums, left, right, target);
  }

  public int helper(int[] nums, int left, int right, int target) {
    if (left >= right) {
      return nums[left] == target ? left : -1;
    }
    int middle = (left + right) / 2;

    if (nums[left] <= nums[middle]) {
      if (target >= nums[left] && target <= nums[middle]) {
        return helper(nums, left, middle, target);
      } else {
        return helper(nums, middle + 1, right, target);
      }
    } else {
      if (nums[middle + 1] <= target && target <= nums[right]) {
        return helper(nums, middle + 1, right, target);
      } else {
        return helper(nums, left, middle, target);
      }
    }
  }

  public int search_2(int[] nums, int target) {
    int index = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        index = i;
        break;
      }
    }
    return index;
  }
}