//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/merge-sorted-array/description/
 */

/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  var copy = new Array(m)
  for (var i = 0; i < m; i++) {
    copy[i] = nums1[i]
  }

  var i = 0, index1 = 0, index2 = 0
  while(index1 < m && index2 < n) {
    if (copy[index1] <= nums2[index2]) {
      nums1[i++] = copy[index1++]
    } else {
      nums1[i++] = nums2[index2++]
    }
  }
  if (index1 >= m) {
    for (var k = index2; k < n; k++) {
      nums1[i++] = nums2[k]
    }
  }
  if (index2 >= n) {
    for (var k = index1; k < m; k++) {
      nums1[i++] = copy[k]
    }
  }
};

/**
 * Doesn't work!
 * Cannot resure the orderness of nums2 when switch num1 and nums2's elements.
 */
var merge = function (nums1, m, nums2, n) {
  var i = 0, index1 = 0, index2 = 0
  while(index1 < m && index2 < n) {
    if (nums1[index1] <= nums2[index2]) {
      i++
      index1++
    } else {
      var temp = nums1[index1++]
      nums1[i++] = nums2[index2]
      nums2[index2] = temp
    }
  }
  if (index1 >= m) {
    for (var k = index2; k < n; k++) {
      nums1[i++] = nums2[k]
    }
  }
}

var merge  = function (nums1, m, nums2, n) {
  var i = m + n - 1
  m--
  n--
  while (n >= 0) {
    if (m >= 0 && (nums1[m] >= nums2[n])) {
      nums1[i--] = nums1[m--]
    } else {
      nums1[i--] = nums2[n--]
    }
  }
}