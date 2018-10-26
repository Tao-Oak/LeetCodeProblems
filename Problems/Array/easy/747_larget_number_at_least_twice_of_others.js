//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function(nums) {
  var maximunIndex = 0, length = nums.length
  if (length < 1) { return -1 }
  for (var i = 1; i < length; i++) {
    if (nums[i] > nums[maximunIndex]) {
      maximunIndex = i
    }
  }
  for (var i = 0; i < length; i++) {
    if (i === maximunIndex) continue
    if (nums[i] * 2 > nums[maximunIndex]) {
      return -1
    }
  }
  return maximunIndex
};