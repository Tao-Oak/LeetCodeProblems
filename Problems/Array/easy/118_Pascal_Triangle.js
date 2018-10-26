//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/pascals-triangle/description/
 */

/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
  if (numRows === 0) return []
  if (numRows === 1) return [[1]]
  if (numRows === 2) return [[1], [1, 1]]

  var result = new Array(numRows)
  result[0] = [1]
  result[1] = [1, 1]

  for (var i = 2; i < numRows; i++) {
    var row = new Array(i + 1)
    row[0] = row[i] = 1
    for (var k = 1; k < i; k++) {
      row[k] = result[i - 1][k - 1] + result[i - 1][k]
    }
    result[i] = row
  }
  return result
};