//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
  var length = nums.length, resultMap = {}

  var haveNearbyDuplicate = false
  for (var i = 0; i < length; i++) {
    var index = resultMap[nums[i]]
    if (index === undefined) {
      resultMap[nums[i]] = i
    } else if (i - index <= k) {
      haveNearbyDuplicate = true
      break
    } else {
      resultMap[nums[i]] = i
    }
  }
  return haveNearbyDuplicate
};

var containsNearbyDuplicate = function (nums, k) {
  var length = nums.length, resultMap = {}

  var haveNearbyDuplicate = false
  for (var i = 0; i <= i + k && i < length; i++) {
    var index = resultMap[nums[i]]
    if (index === undefined) {
      resultMap[nums[i]] = i
    } else if (i - index <= k) {
      haveNearbyDuplicate = true
      break
    } else {
      resultMap[nums[i]] = i
    }
  }
  return haveNearbyDuplicate
}