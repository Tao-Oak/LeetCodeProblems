//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  var length = numbers.length
  for (var i = 0; i < length; i++) {
    for (var k = i + 1; i < length; k++) {
      if (numbers[i] + numbers[k] === target) {
        return [i + 1, k + 1]
      }
    }
  }
};

var twoSum_2 = function(numbers, target) {
  var length = numbers.length
  var middleValue = target / 2

  var sValLowIdx = 0, sValHighIdx
  var bValLowIdx, bValHighIdx = length - 1

  for (var i = 0; i < length; i++) {
    if (numbers[i] > middleValue) {
      bValLowIdx = i
      sValHighIdx = i === 0 ? i : i - 1
      break
    } else if (numbers[i] === middleValue) {
      sValHighIdx = i
      bValLowIdx = i === length - 1 ? i : i + 1
      break
    }
  }

  for (var i = sValLowIdx; i <= sValHighIdx; i++) {
    for (var k = bValLowIdx; k <= bValHighIdx; k++) {
      if (numbers[i] + numbers[k] === target) {
        return [i + 1, k + 1]
      }
    }
  }
}

var twoSum_3 = function (numbers, target) {
  var findIndex = function (low, high, value) {
    while (low <= high) {
      if (low === high) {
        return numbers[low] === value ? low : undefined
      }
      var middle = Math.floor((low + high) / 2)
      if (value <= numbers[middle]) {
        high = middle
      } else {
        low = middle + 1
      }
    }
  }

  var length = numbers.length
  for (var i = 0; i < length; i++) {
    var value = target - numbers[i]
    var index = findIndex(i + 1, length - 1, value)
    if (index) {
      return [i+1, index + 1]
    }
  }
}

var twoSum_4 = function (numbers, target) {
  var left = 0, right = numbers.length - 1
  while(left < right) {
    var v = numbers[left] + numbers[right]
    if (v === target) {
      return [left + 1, right + 1]
    } else if (v > target) {
      right--
    } else {
      left++
    }
  }
  return [0, 0]
}