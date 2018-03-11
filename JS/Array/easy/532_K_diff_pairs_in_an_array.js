//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findPairs = function(nums, k) {
  if (k < 0) return 0
  var length = nums.length, resultMap = {}, counter = 0

  for (var i = 0; i < length; i++) {
    var target_1 = nums[i] - k, target_2 = nums[i] + k
    for (var j = i + 1; j < length; j++) {
      if (target_1 !== nums[j] && target_2 !== nums[j]) {
        continue
      }
      var key = nums[i] + nums[j]
      if (resultMap[key] === undefined) {
        resultMap[key] = true
        counter++
      }
    }
  }
  return counter
};

var findPairs = function (nums, k) {
  if (!nums || nums.length === 0 || k < 0) {
    return 0
  }

  var count = 0, resultMap = {}
  nums.forEach(function (item) {
    resultMap[item] = (resultMap[item] || 0) + 1
  })

  Object.keys(resultMap).forEach(function (propName) {
    if (k === 0) {
      if (resultMap[propName] >= 2) {
        count++
      }
    } else {
      var target = parseInt(propName) + k
      if (resultMap[target] !== undefined) {
        count++
      }
    }
  })
  return count
}