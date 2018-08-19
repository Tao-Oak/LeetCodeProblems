//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/max-area-of-island/description/
 */

/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
  var rows = grid.length
  if (rows <= 0) return 0
  var columns = grid[0].length
  if (columns <= 0) return 0

  var maxArea = 0
  for (var r = 0; r < rows; r++) {
    for (var c = 0; c < columns; c++) {
      if (grid[r][c] === 0 || !equalToZero(r - 1, c) || !equalToZero(r, c - 1)) {
        continue
      }
      var area = calculateArea(r, c, 0)
      maxArea = Math.max(maxArea, area)
    }
  }

  function equalToZero (r, c) {
    if (r < 0 || r >= rows || c < 0 || c >= columns) {
      return true
    }
    return grid[r][c] === 0
  }

  function calculateArea (r, c, level) {
    var area = 1
    grid[r][c] = 0
    if (!equalToZero(r - 1, c)) {
      area += calculateArea(r - 1, c, level + 1)
    }
    if (!equalToZero(r, c + 1)) {
      area += calculateArea(r, c + 1, level + 1)
    }
    if (!equalToZero(r + 1, c)) {
      area += calculateArea(r + 1, c, level + 1)
    }
    if (!equalToZero(r, c - 1)) {
      area += calculateArea(r, c - 1, level + 1)
    }

    return area
  }
  return maxArea
};