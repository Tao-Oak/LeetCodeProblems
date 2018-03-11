//
// Created by CaoTao, 2018/03/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 */

/**
 * @param {number[]} bits
 * @return {boolean}
 */
var isOneBitCharacter = function(bits) {
  var length = bits.length

  for (var i = 0; i < length; i++) {
    if (bits[i] === 1) {
      if (i >= length - 2) {
        return false
      }
      i++
    } else {
      if (i >= length - 1) {
        return true
      }
    }
  }
};

var isOneBitCharacter = function(bits) {
  var length = bits.length, i = 0

  while (i < length - 1) {
    if (bits[i] === 0) {
      i++
    } else {
      i += 2
    }
  }
  return i === length - 1
};