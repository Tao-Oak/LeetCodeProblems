//
// Created by Joshua.Cao, 2018/03/08
//
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
//

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  var length = prices.length

  var profit = 0
  for (var i = 1; i < length; i++) {
    if (prices[i] > prices[i - 1]) {
      profit += prices[i] - prices[i -1]
    }
  }
  return profit
};