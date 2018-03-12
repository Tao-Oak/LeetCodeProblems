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
    var i = 0, j = c
    if (!isSame(i, j)) {
      return false
    }
    , lastEle = undefined
    while (i < rows && j < columns) {
      if (lastEle !== undefined && lastEle !== matrix[i][j]) {
        return false
      }
      lastEle = matrix[i++][j++]
    }
  }
  for (var r = 0; r < rows; r++) {
    var i = r, j = 0, lastEle = undefined
    while (i < rows && j < columns) {
      if (lastEle !== undefined && lastEle !== matrix[i][j]) {
        return false
      }
      lastEle = matrix[i++][j++]
    }
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