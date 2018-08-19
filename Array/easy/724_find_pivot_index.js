//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/find-pivot-index/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
  var curPivotIndex = -1, length = nums.length

  var leftSum = 0
  var rigthSum = nums.reduce(function (sum, item) {
    return sum + item
  }, 0)

  for (var i = 0; i < length; i++) {
    if (i > 0) {
      leftSum += nums[i - 1]
    }
    rigthSum -= nums[i]
    if (leftSum === rigthSum) {
      curPivotIndex = i
      break
    }
  }
  return curPivotIndex
};

var pivotIndex = function(nums) {
  var leftSum = 0
  var totalSum = nums.reduce(function (sum, item) {
    return sum + item
  }, 0)

  for (var i = 0; i < nums.length; leftSum += nums[i++]) {
    if (leftSum * 2 === totalSum - nums[i]) {
      return i
    }
  }
  return -1
};