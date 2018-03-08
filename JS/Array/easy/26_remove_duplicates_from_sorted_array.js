//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  var length = nums.length
  for (var i = 0; i < length; i++) {
    for (var k = i + 1, insertPos = i + 1; k < length; k++) {
      if (nums[i] === nums[k]) {
        continue
      }
      if (k > insertPos) {
        nums[insertPos] = nums[k]
      }
      insertPos++
    }
    length = insertPos
  }
  return length
}

var removeDuplicates_2 = function (nums) {
  var length = nums.length
  for (var i = 0; i < length; i++) {
    if (nums[i] === undefined) {
      continue
    }
    for (var k = i + 1; k < length; k++) {
      if (nums[i] === nums[k]) {
        nums[k] = undefined
      }
    }
  }

  for (var i = 0, insertPos = 0; i < length; i++) {
    if (nums[i] === undefined) {
      continue
    }
    nums[insertPos] = nums[i]
    insertPos++
  }

  return insertPos
}

var removeDuplicates_3 = function (nums) {
  var length = nums.length
  for (var i = 1, insertPos = 1; i < length; i++) {
    if (nums[i] !== nums[i - 1]) {
      nums[insertPos++] = nums[i]
    }
  }
  return insertPos
}