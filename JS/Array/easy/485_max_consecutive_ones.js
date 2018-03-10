//
// Created by CaoTao, 2018/03/09
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */

// cannot work
// We need to return then maximum number of consecutive 1s
var findMaxConsecutiveOnes = function(nums) {
  var maxConsecutiveOnes = 1, currentValue = nums[0], consecutiveOnes = 1
  for (var i = 1; i < nums.length; i++) {
    if (currentValue === nums[i]) {
      consecutiveOnes++
    } else {
      currentValue = nums[i]
      if (consecutiveOnes > maxConsecutiveOnes) {
        maxConsecutiveOnes = consecutiveOnes
      }
      consecutiveOnes = 1
    }
  }
  return maxConsecutiveOnes
};

var findMaxConsecutiveOnes = function(nums) {
  var maxConsecutiveOnes = 0, consecutiveOnes = 0
  for (var i = 0; i < nums.length; i++) {
    if (nums[i] === 1) {
      consecutiveOnes++
    } else {
      maxConsecutiveOnes = Math.max(maxConsecutiveOnes, consecutiveOnes)
      consecutiveOnes = 0
    }
  }
  return Math.max(maxConsecutiveOnes, consecutiveOnes)
};

var findMaxConsecutiveOnes = function(nums) {
  var divideAndConquer = function (nums, left, right) {
    if (left === right) {
      return nums[left]
    }

    var middle = Math.floor((left + right) / 2)
    var leftValue = divideAndConquer(nums, left, middle)
    var rightValue = divideAndConquer(nums, middle + 1, right)
    var middleValue = 0

    while (middle >= left && nums[middle] === 1) {
      middleValue++
      middle--
    }
    middle = middle + middleValue + 1
    while(middle <= right && nums[middle] === 1) {
      middleValue++
      middle++
    }
    return Math.max(leftValue, middleValue, rightValue)
  }
  return divideAndConquer(nums, 0, nums.length -1)
}

// Wrote by biubiu
var findMaxConsecutiveOnes_3 = function(nums) {
  var merge = function(nums, l1, r1, l2, r2) {
    var count = 0;
    while(nums[r1] === 1 && r1 >= l1) {
      count++;
      r1--;
    }
    while(nums[l2] === 1 && l2 <= r2) {
      count++;
      l2++;
    }
    return count;
  }

  var sub_maxConse = function(nums, left, right) {
    if(left === right) {
      return nums[left]
    }
    var middle, leftRes, rightRes, mergeRes;
    middle = Math.floor((left+right)/2)
    leftRes = sub_maxConse(nums, left, middle)
    rightRes = sub_maxConse(nums, middle+1, right)
    mergeRes = merge(nums, left, middle, middle+1, right);
  
    return Math.max(leftRes, mergeRes, rightRes);
  }

  return sub_maxConse(nums, 0, nums.length-1)
}
