//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/find-pivot-index/description/
 */

/**
 * @param {number[][]} M
 * @return {number[][]}
 */
var imageSmoother = function(M) {
  var rows = M.length, columns = M[0].length

  var newMatrix = new Array(rows)
  for (var i = 0; i < rows; i++) {
    newMatrix[i] = new Array(columns)
  }

  for (var r = 0; r < rows; r++) {
    for (var c = 0; c < columns; c++) {
      var surCells = []
      getSurroundingCells(surCells, r - 1, c)
      getSurroundingCells(surCells, r, c)
      getSurroundingCells(surCells, r + 1, c)

      var sum = surCells.reduce(function (sum, item) {
        return sum + M[item[0]][item[1]]
      }, 0)
      newMatrix[r][c] = Math.floor(sum / surCells.length)
    }
  }

  function getSurroundingCells (surCells, r, c) {
    if (r < 0 || r >= rows) {
      return
    }
    if (c - 1 >= 0) {
      surCells.push([r, c - 1])
    }
    surCells.push([r, c])
    if (c + 1 < columns) {
      surCells.push([r, c + 1])
    }
  }
  return newMatrix
};

var imageSmoother = function(M) {
  var rows = M.length, columns = M[0].length

  var newMatrix = new Array(rows)
  for (var i = 0; i < rows; i++) {
    newMatrix[i] = new Array(columns)
  }

  var dirs = [
    [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1]
  ]
  for (var r = 0; r < rows; r++) {
    for (var c = 0; c < columns; c++) {
      var sum = M[r][c], count = 1
      for (var k = 0; k < dirs.length; k++) {
        var x = r + dirs[k][0], y = c + dirs[k][1]
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
          continue
        }
        sum += (M[x][y] & 0xFF)
        count++
      }
      M[r][c] = M[r][c] | Math.floor(sum /count) << 8
    }
  }
  for (var r = 0; r < rows; r++) {
    for (var c = 0; c < columns; c++) {
      M[r][c] = M[r][c] >> 8
    }
  }
  return M
}