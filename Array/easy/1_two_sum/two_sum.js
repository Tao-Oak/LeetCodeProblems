//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/two-sum/description/
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  var resultMap = {}

  for (var i = 0; i < nums.length; i++) {
    var expected = target - nums[i]
    if (resultMap[expected] !== undefined) {
      return [resultMap[expected], i]
    }
    resultMap[nums[i]] = i
  }
};