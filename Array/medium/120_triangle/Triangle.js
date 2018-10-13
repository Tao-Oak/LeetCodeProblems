//
// Created by Joshua.cao, 2018/10/13
//
// https://leetcode.com/problems/triangle/description/
//
/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
  for (let i = triangle.length - 2; i >= 0; i--) {
    for (let j = 0; j < triangle[i].length; j++) {
      triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1])
    }
  }
  return triangle[0][0]
}

var minimumTotal_2 = function(triangle) {
  const rows = triangle.length
  let costMap = {}
  function helper(row, column) {
    if (row + 1 === rows) {
      costMap[row * rows + column] = triangle[row][column]
      return triangle[row][column]
    }

    const temp = (row + 1) * rows
    let leftCost = costMap[temp + column]
    if (leftCost === undefined) {
      leftCost = helper(row + 1, column)
    }

    let rightCost = costMap[temp + column + 1]
    if (rightCost === undefined) {
      rightCost = helper(row + 1, column + 1)
    }

    let cost = Math.min(leftCost, rightCost) + triangle[row][column]
    costMap[row * rows + column] = cost
    return cost
  }
  let totalCost = helper(0, 0)
  return totalCost
}

const triangle = [
  [2],
  [3,4],
  [6,5,7],
  [4,1,8,3]
]
console.log(minimumTotal(triangle))

const triangle_2 = [
  [-1],
  [ 9,-2],
  [ 0, 4, 5],
  [ 7, 4,-4,-5],
  [ 9, 6, 0, 5, 7],
  [ 9, 2,-9,-4, 5,-2],
  [-4,-9,-5,-7,-5,-5,-2],
  [-9, 5,-6,-4, 4, 1, 6,-4],
  [-4, 3, 9,-2, 8, 6,-9,-2,-2],
  [ 7,-6, 9, 8,-4, 2,-4,-2,-1,-2],
  [ 0, 3, 2, 4, 0,-6, 7, 6, 7,-5, 2],
  [ 9, 0,-8, 6, 4, 6, 2, 5,-9, 9,-1,-6],
  [ 6,-3,-4,-5, 0, 3, 3, 4,-6,-4,-7, 7, 3]
]
console.log(minimumTotal(triangle_2))