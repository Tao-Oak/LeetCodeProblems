//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/majority-element/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  var length = nums.length
  var majority = nums[0]
  var resultMap = {}
  resultMap[majority] = 1

  for (var i = 1; i < length; i++) {
    var times = resultMap[nums[i]]
    if (times === undefined) {
      resultMap[nums[i]] = 1
    } else {
      resultMap[nums[i]] = ++times
      if (times > resultMap[majority]) {
        majority = nums[i]
      }
    }
  }
  return majority
};

// http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
var majorityElement = function (nums) {
  var majority = nums[0], count = 1
  for (var i = 1; i < nums.length; i++) {
    if (count === 0) {
      count++
      majority = nums[i]
    } else if (majority === nums[i]) {
      count++
    } else {
      count--
    }
  }
  return majority
}