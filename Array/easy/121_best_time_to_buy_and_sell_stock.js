//
// Created by CaoTao, 2018/03/08
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  var findMinimunValue = function (nums, left, right) { 
    if (right === left) {
      return nums[right]
    }
    var middle = Math.floor((left + right) / 2)
    var leftMin = findMinimunValue(nums, left, middle)
    var rightMin = findMinimunValue(nums, middle + 1, right)
    return leftMin < rightMin ? leftMin : rightMin
  }

  var profit = 0
  var length = prices.length
  for (var i = length - 1; i >= 1; i--) {
    let minimun = findMinimunValue(prices, 0, i - 1)
    var difference = prices[i] - minimun
    if (difference > profit) {
      profit = difference
    }
  }
  return profit
};

var maxProfit = function(prices) {
  var profit = 0, minimun = Number.POSITIVE_INFINITY
  var length = prices.length
  for (var i = 1; i < length; i++) {
    if (prices[i - 1] < minimun) {
      minimun = prices[i - 1]
    }
    var difference = prices[i] - minimun
    if (difference > profit) {
      profit = difference
    }
  }
  return profit
}