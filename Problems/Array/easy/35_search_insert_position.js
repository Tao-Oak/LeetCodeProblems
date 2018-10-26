//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/search-insert-position/description/
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    var insertPosition = -1
    for (var i = 0; i < nums.length; i++) {
        if (nums[i] >= target) {
            insertPosition = i
            break
        }
    }
    if (insertPosition === -1) {
        insertPosition = nums.length
    }
    return insertPosition
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert_2 = function(nums, target) {
  var low = 0, high = nums.length - 1
  while (low <= high) {
    if (low === high) {
      return nums[low] >= target ? low : high + 1
    }
    var middle = Math.floor((low + high) / 2)
    if (nums[middle] >= target) {
      high = middle
    } else {
      low = middle + 1
    }
  }
};