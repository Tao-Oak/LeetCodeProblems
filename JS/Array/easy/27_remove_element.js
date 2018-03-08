//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/move-zeroes/description/
 */

/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
  var length = nums.length
  for (var i = 0, insertPosition = 0; i < length; i++) {
    if (nums[i] === val) {
      continue
    }
    nums[insertPosition] = nums[i]
    insertPosition++
  }
  for (var i = insertPosition; i < length; i++) {
    nums.pop()
  }
  return nums
};