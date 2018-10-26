//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/plus-one/description/
 */

/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  var reversed = digits.reverse()

  var carray = 0
  var temp = digits[0] + 1
  if (temp >= 10) {
    carray = 1
    digits[0] = temp - 10
  } else {
    digits[0] = temp
  }
  
  for (var i = 1; i < reversed.length; i++) {
    var temp = digits[i] + carray
    if (temp >= 10) {
      carray = 1
      digits[i] = temp - 10
    } else {
      carray = 0
      digits[i] = temp
      break
    }
  }
  if (carray > 0) {
    reversed[i] = carray
  }
  return reversed.reverse()
};

var plusOne_2 = function(digits) {
  var length = digits.length
  for (var i = length - 1; i>= 0; i--) {
    if (digits[i] < 9) {
      digits[i]++
      return digits
    }
    digits[i] = 0
  }
  var newArray = new Array(length + 1)
  newArray[0] = 1
  for (var i = 1; i <= length; i++) {
    newArray[i] = 0
  }
  return newArray
} 