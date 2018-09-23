//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
//
public class SearchRotatedArrayTwo {
  // Accepted: Beats 100%
  public boolean search(int[] nums, int target) {
    boolean found = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        found = true;
        break;
      }
    }
    return found;
  }
}