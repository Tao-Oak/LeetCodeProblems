//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/toeplitz-matrix/description/
 */

/**
 * @param {number[][]} matrix
 * @return {boolean}
 */
var isToeplitzMatrix = function(matrix) {
  var rows = matrix.length, columns = matrix[0].length
  
  for (var c = 0; c < columns; c++) {
    if (!isSame(0, c)) return false
  }
  for (var r = 0; r < rows; r++) {
    if (!isSame(r, 0)) return false
  }

  function isSame (i, j) {
    var lastEle = undefined
    while (i < rows && j < columns) {
      if (lastEle !== undefined && lastEle !== matrix[i][j]) {
        return false
      }
      lastEle = matrix[i++][j++]
    }
    return true
  }

  return true
};