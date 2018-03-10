//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/third-maximum-number/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var thirdMax = function(nums) {
  var resultMap = {}, length = nums.length
  var maximum = secondMax = thirdMaximum = Number.NEGATIVE_INFINITY

  for (var i = 0; i < length; i++) {
    if (nums[i] >= maximum) {
      if (nums[i] === maximum) continue
      thirdMaximum = secondMax
      secondMax = maximum
      maximum = nums[i]
    } else if (nums[i] >= secondMax) {
      if (nums[i] === secondMax) continue
      thirdMaximum= secondMax
      secondMax = nums[i]
    } else if (nums[i] > thirdMaximum) {
      thirdMaximum = nums[i]
    }
  }

  return thirdMaximum === Number.NEGATIVE_INFINITY ? maximum : thirdMaximum
};