//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/missing-number/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
  var length = nums.length
  // item may overflow
  var totalSum = length * (length + 1) / 2
  var sum = nums.reduce((sum, item, idx) => {
    return sum + item
  }, 0)
  return totalSum - sum
};

// a ^ b ^ b = a
var missingNumber = function (nums) {
  return nums.reduce((sum, item, index) => {
    return sum^index^item
  }, nums.length)
}