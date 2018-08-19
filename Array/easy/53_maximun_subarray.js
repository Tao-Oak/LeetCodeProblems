//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/maximum-subarray/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  var length = nums.length
  if (length < 2) {
    return nums[0]
  }

  var maxSum = nums[0], currentMaxSum = nums[0]
  for (var i = 1; i < length; i++) {
    currentMaxSum = currentMaxSum > 0 ? currentMaxSum + nums[i] : nums[i]
    if (currentMaxSum > maxSum) {
      maxSum = currentMaxSum
    }
  }
  return maxSum
};