//
// Created by CaoTao, 2018/03/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/reshape-the-matrix/description/
 */

/**
 * @param {number[][]} nums
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(nums, r, c) {
  var originRows = nums.length
  if (originRows <= 0) {
    return nums
  }
  var originColumns = nums[0].length
  if (originColumns <= 0) {
    return nums
  }
  var eleCount = r * c
  if (originRows * originColumns !== eleCount) {
    return nums
  }
  var resultMatrix = new Array(r)
  for (var i = 0; i < r; i++) {
    resultMatrix[i] = new Array(c)
  }
  var oldRow = 0, oldColumn = 0, newRow = 0, newColumn = 0
  resultMatrix[0][0] = nums[0][0]
  for (var i = 1; i < eleCount; i++) {
    oldRow = Math.floor(i / originColumns)
    oldColumn = i % originColumns
    newRow = Math.floor(i / c)
    newColumn = i % c
    resultMatrix[newRow][newColumn] = nums[oldRow][oldColumn]
  }
  return resultMatrix
};