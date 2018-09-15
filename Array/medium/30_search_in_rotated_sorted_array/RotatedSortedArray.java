//
// Created by CaoTao, 2018/09/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class RotatedSortedArray {
  public int search(int[] nums, int target) {
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