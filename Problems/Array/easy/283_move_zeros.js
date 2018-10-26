//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/move-zeroes/description/
 */

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  var length = nums.length
  for (var i = 0, nonZeroIndex = 0; i < length; i++) {
    if (nums[i] === 0) {
      continue
    }
    if (i > nonZeroIndex) {
      nums[nonZeroIndex] = nums[i]
    }
    nonZeroIndex++
  }
  for (var i = nonZeroIndex; i < length; i++) {
    nums[i] = 0
  }
};