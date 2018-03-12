//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumProduct = function(nums) {
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
    if (low >= hight) {
      return
    }
    var middle = partition(nums, low, hight)
    quickSort(nums, low, middle - 1)
    quickSort(nums, middle + 1, hight)
  }
  var length = nums.length
  quickSort(nums, 0, length - 1)
  return Math.max(
    nums[length - 1] * nums[0] * nums[1],
    nums[length - 1] * nums[length - 2] * nums[length - 3]
  )
};

var maximumProduct = function(nums) {
  var firstMin = secondMin = Number.POSITIVE_INFINITY
  var firstMax = secondMax = thirdMax = Number.NEGATIVE_INFINITY
  for (var i = 0; i < nums.length; i++) {
    if (nums[i] <= firstMin) {
      secondMin = firstMin
      firstMin = nums[i]
    } else if (nums[i] <= secondMin) {
      secondMin = nums[i]
    }
    
    if (nums[i] >= firstMax) {
      thirdMax = secondMax
      secondMax = firstMax
      firstMax = nums[i]
    } else if (nums[i] >= secondMax) {
      thirdMax = secondMax
      secondMax = nums[i]
    } else if (nums[i] >= thirdMax) {
      thirdMax = nums[i]
    }
  }
  return Math.max(
    firstMax * firstMin * secondMin,
    firstMax * secondMax * thirdMax
  )
}