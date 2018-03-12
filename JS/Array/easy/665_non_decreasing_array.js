//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/non-decreasing-array/description/
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var checkPossibility = function(nums) {
  var trailingEdgeCnt = 0, length = nums.length
  for (var i = 1; i < length; i++) {
    if (nums[i] < nums[i - 1]) {
      trailingEdgeCnt++
      if (i > 1 && i < length - 1 && nums[i + 1] <= nums[i -1]) {
        return false
      }
    }
  }
  return trailingEdgeCnt <= 1
};