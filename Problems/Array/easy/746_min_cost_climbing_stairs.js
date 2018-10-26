//
// Created by CaoTao, 2018/03/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */

/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
  var length = cost.length
  var minCostArray = [cost[0], cost[1]]

  for (var i = 2; i < length; i++) {
    minCostArray[i] = cost[i] + Math.min(minCostArray[i - 1], minCostArray[i - 2])
  }

  return Math.min(minCostArray[length - 1], minCostArray[length - 2])
};