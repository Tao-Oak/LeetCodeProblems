//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/degree-of-an-array/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var findShortestSubArray = function(nums) {
  var resultMap = {}, maxDegree = 1

  nums.forEach(function (item, index) {
    var temp = resultMap[item]
    if (temp) {
      temp.end = index
      temp.count = temp.count + 1
      if (temp.count > maxDegree) {
        maxDegree = temp.count
      }
    } else {
      resultMap[item] = { start: index, end: index, count: 1}
    }
  })
  if (maxDegree === 1) {
    return 1
  }

  var minLength = 50000
  Object.keys(resultMap).forEach(function (propName) {
    var item = resultMap[propName]
    if (item.count === maxDegree) {
      var diff = item.end - item.start + 1
      if (diff < minLength) {
        minLength = diff
      }
    }
  })
  return minLength
};