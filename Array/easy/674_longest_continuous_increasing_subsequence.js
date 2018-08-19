//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
  var length = nums.length
  if (length <= 0) { return 0 }
  var start = 0, end = 0, subArrLen = 1

  for (var i = 1; i < length; i++) {
    if (nums[i] > nums[i - 1]) {
      end = i
    } else {
      subArrLen = Math.max(subArrLen, end - start + 1)
      start = end = i
    }
  }
  return Math.max(subArrLen, end - start + 1)
};