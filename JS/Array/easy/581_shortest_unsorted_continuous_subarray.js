//
// Created by CaoTao, 2018/03/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray = function(nums) {
  var length = nums.length
  var start = -1, end = -2
  var maxValue = nums[0], minValue = nums[length - 1]
  
  for (var i = 1; i < length; i++) {
    if (nums[i] < maxValue || nums[i] < nums[i - 1]) {
      end = i
      continue
    }
    maxValue = Math.max(maxValue, nums[i])
  }
  for (i = length - 2; i >= 0; i--) {
    if (nums[i] > minValue || nums[i] > nums[i + 1]) {
      start = i
      continue
    }
    minValue = Math.min(minValue, nums[i])
  }

  return start > end ? 0 : end - start + 1
};