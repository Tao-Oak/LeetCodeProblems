//
// Created by CaoTao, 2018/09/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
class FirstAndLastPosition {
  public int[] searchRange(int[] nums, int target) {
    int length = nums.length;
    if (length <= 0 || target < nums[0] || target > nums[length - 1]) {
      return new int[]{-1, -1};
    }

    int[] result = {-1, -1};

    for (int i = 0; i < length; i++) {
      if (target == nums[i]) {
        if (result[0] == -1) {
          result[0] = i;
        }
        result[1] = i;
      }
    }
    return result;
  }

  public int[] searchRange_2(int[] nums, int target) {
    int[] result = {-1, -1};
    if (nums.length <= 0) {
      return result;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      if (nums[middle] > target) {
        right = middle - 1;
        continue;
      } else if (nums[middle] < target) {
        left = middle + 1;
        continue;
      }
      result[0] = middle;
      result[1] = middle;
      int leftOffset = 0, rightOffset = 0;
      while (middle + rightOffset < nums.length && nums[middle + rightOffset] == target) {
        result[1] = middle + rightOffset++;
      }
      while (middle - leftOffset >= 0 && nums[middle - leftOffset] == target) {
        result[0] = middle - leftOffset++;
      }
      break;
    }
    return result;
  }
}