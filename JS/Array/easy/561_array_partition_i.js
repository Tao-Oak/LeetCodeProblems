//
// Created by CaoTao, 2018/03/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/array-partition-i/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
  nums.sort(function (a, b) {
    if (a > b) {
      return 1
    } if (a < b) {
      return -1
    }
    return 0
  })

  var sum = 0
  for (var i = 0; i < nums.length; i += 2) {
    sum += nums[i]
  }
  return sum
};

var arrayPairSum = function (nums) {
  var partition = function (nums, low, high) {
    if (low === high) {
      return
    }
    var pivot = nums[low]
    var i = low + 1, j = high

    while (j >= i) {
      if (nums[j] >= pivot) {
        j--
        continue
      }

      nums[i - 1] = nums[j]
      nums[j] = nums[i]
      nums[i] = pivot
      i++
    }
    return i - 1
  }

  var quickSort = function (nums, low, hight) {
    console.log(`low: ${low} high: ${hight}`)
    if (low >= hight) {
      return
    }
    var middle = partition(nums, low, hight) - 1
    console.log(`middle: ${middle}`)
    quickSort(nums, low, middle - 1)
    quickSort(nums, middle + 1, hight)
  }

  quickSort(nums, 0, nums.length - 1)
  var sum = 0
  for (var i = 0; i < nums.length; i += 2) {
    sum += nums[i]
  }
  return sum
}