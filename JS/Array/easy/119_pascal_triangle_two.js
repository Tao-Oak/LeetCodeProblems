//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */

/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
  var factorialMap = new Array(rowIndex + 1)
  for (var i = 0; i <= rowIndex; i++) {
    if (i === 0 || i === 1) {
      factorialMap[i] = 1
    } else {
      factorialMap[i] = factorialMap[i - 1] * i
    }
  }

  var result = new Array(rowIndex + 1)
  for (var i = 0; i <= rowIndex; i++) {
    result[i] = factorialMap[rowIndex] / (factorialMap[i] * factorialMap[rowIndex - i])
  }
  return result
};

var getRow_2 = function (rowIndex) {
  var result = new Array(rowIndex + 1)
  for (var i = 1; i <= rowIndex; i++) {
    result[i] = 0
  }
  result[0] = 1

  for (var i = 1; i <= rowIndex; i++) {
    for (var k = i; k >= 1; k--) {
      result[k] = result[k] + result[k - 1]
    }
  }
  return result
}