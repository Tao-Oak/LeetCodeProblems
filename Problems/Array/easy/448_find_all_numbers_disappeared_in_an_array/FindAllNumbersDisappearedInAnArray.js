//
// Created by CaoTao, 2018/03/09
//
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
//

// O(n) runtime without extra space
var findDisappearedNumbers = function(nums) {
  var length = nums.length
  for (var i = 0; i < length; i++) {
    var destIndex = nums[i] - 1
    while (nums[i] - 1 !== i && nums[i] !== undefined) {
      if (nums[i] === nums[nums[i] - 1]) {
        nums[i] = undefined
      }
      var temp = nums[nums[i] - 1]
      nums[nums[i] - 1] = nums[i]
      nums[i] = temp
    }
  }

  var result = []
  for (var i = 0; i < length; i++) {
    if (nums[i] === undefined) {
      result.push(i + 1)
    }
  }

  return result
};

// O(n) runtime with O(n) extra space
var findDisappearedNumbers = function(nums) {
  var length = nums.length, tempArray = new Array(5)

  for (var i = 0; i < length; i++) {
    tempArray[nums[i] - 1] = nums[i]
  }

  var result = []
  for (var i = 0; i < length; i++) {
    if (tempArray[i] === undefined) {
      result.push(i + 1)
    }
  }

  return result
}