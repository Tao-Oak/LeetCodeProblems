//
// Created by Joshua.cao, 2018/10/12
//
// https://leetcode.com/problems/subsets/description/
//

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
  // Array.prototype.sort.call(nums, (a, b) => a - b)
  let markers = [], resultSet = []
  for (let i = 0; i < nums.length; i++) {
    markers[i] = false;
  }
  
  function helper(start) {
    if (start > nums.length) return

    let temp = []
    for (let i = 0; i < nums.length; i++) {
      if (markers[i]) temp.push(nums[i])
    }
    resultSet.push(temp)

    for (let i = start; i < nums.length; i++) {
      markers[i] = true
      helper(i + 1)
      markers[i] = false
    }
  }
  helper(0)
  return resultSet
}

const nums_1 = [1,2,3]
console.log(subsets(nums_1))