//
// Created by CaoTao, 2018/03/14
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/3sum-closest/description/
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
  if (nums.count < 3) {
    return 
  }
  nums.sort(function (a, b) { return a - b })
  var low, high, sum, closestSum
  for (var i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i] === nums[i - 1]) continue
    low = i + 1
    high = nums.length - 1
    while (low < high) {
      if (low > i + 1 && nums[low] === nums[low - 1]) {
        low++
        continue
      }
      if (i < nums.length - 1 && nums[i] === nums[high + 1]) {
        high--
        continue
      }
      
      sum = nums[i] + nums[low] + nums[high]
      if (sum === target) { return sum }
      if (closestSum === undefined) {
        closestSum = sum
      } else if (Math.abs(closestSum - target) > Math.abs(sum - target)){
        closestSum = sum
      }
      if (sum > target) {
        high--
      } else if (sum < target) {
        low++
      }
    }
  }
  return closestSum
};

console.log(
  threeSumClosest([-1,2,1,-4], 1)
)