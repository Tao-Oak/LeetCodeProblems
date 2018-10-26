//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/rotate-array/description/
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  if (k === 0 || nums.length === 0){
    return
  }
  var length = nums.length
  var step = k % length
  if (step === 0) {
    return
  }

  var copy = Array.from(nums)
  var p = length - step
  for (var i = 0; i < length; i++) {
    if (i < p) {
      nums[i + step] = copy[i]
    } else {
      nums[i - p] = copy[i]
    }
  }
};

function findGCD (a, b) {
  if (a === b) {
    return a
  }
  if (a > b) {
    a = a - b
  } else {
    b = b -a
  }

  return findGCD(a, b)
}

function findGCD_2 (a, b) {
  while (a !== b) {
    if (a > b) {
      a = a - b
    } else {
      b = b - a
    }
  }
  return a
}

function findGCD_3 (a, b) {
  var small, big
  if (a >= b) {
    small = b
    big = a
  } else {
    small = a
    big = b
  }
  var remain = big % small
  if (remain === 0) {
    return small
  }
  return findGCD_3(small, remain)
}

function findGCD_4 (a, b) {
  var small, big
  if (a >= b) {
    small = b
    big = a
  } else {
    small = a
    big = b
  }
  while (big % small !== 0) {
    var remain = big % small
    big = small
    small = remain
  }
  return small
}

var rotate = function (nums, k) {
  var length = nums.length
  if (k === 0 || length === 0) {
    return
  }
  var step = k % length
  if (step === 0) {
    return
  }

  var gcd = findGCD(length, step)
  var desIndex, srcIndex = length - step
  var tempArr = new Array(gcd)
  for (var i = 0; i < gcd; i++) {
    tempArr[i] = nums[srcIndex + i]
  }
  do {
    desIndex = (srcIndex + step) % length
    for (var i = 0; i < gcd; i++) {
      var temp = nums[desIndex + i]
      nums[desIndex + i] = tempArr[i]
      tempArr[i] = temp
    }
    srcIndex = desIndex
  } while (srcIndex !== length - step)
}