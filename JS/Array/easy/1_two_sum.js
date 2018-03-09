//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  var resultMap = {}

  for (var i = 0; i < nums.length; i++) {
    console.log(`target: ${target}, nums[i]: ${nums[i]}`)
    var expected = target - nums[i]
    console.log('expected:', expected)
    console.log('resultMap:', resultMap)
    if (resultMap[expected] !== undefined) {
      return [i, resultMap[expected]]
    }
    resultMap[nums[i]] = i
  }
};