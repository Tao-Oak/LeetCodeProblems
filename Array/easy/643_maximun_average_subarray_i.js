//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
  var length = nums.length
  var maxAverage = Number.NEGATIVE_INFINITY

  for (var i = 0; i <= length - k; i++) {
    var sum = 0
    for (var j = 0; j < k; j++) {
      sum += nums[i + j]
    }
    maxAverage = Math.max(maxAverage, sum / k)
  }
  return maxAverage
};

var findMaxAverage = function(nums, k) {
  var length = nums.length
  var maxSum = 0, sum = 0
  for (var i = 0; i < k; i++) {
    sum += nums[i]
  }
  maxSum = sum
  for (var i = 1; i <= length - k; i++) {
    sum = sum - nums[i - 1] + nums[i + k - 1]
    maxSum = Math.max(maxSum, sum)
  }
  return maxSum / k
};

