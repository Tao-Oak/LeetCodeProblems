//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/contains-duplicate/description/
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
  var length = nums.length, resultMap = {}

  var duplicated = false
  for (var i = 0; i < length; i++) {
    var count = resultMap[nums[i]]
    if (count === undefined) {
      resultMap[nums[i]] = 1
    } else {
      duplicated = true
      break
    }
  }
  return duplicated
};