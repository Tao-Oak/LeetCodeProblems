//
// Created by Joshua.cao, 2018/10/12
//
// https://leetcode.com/problems/subsets-ii/description/
//

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
  Array.prototype.sort.call(nums, (a, b) => a - b)
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
      if (i !== start && nums[i] === nums[i - 1]) {
        continue
      }
      markers[i] = true
      helper(i + 1)
      markers[i] = false
    }
  }
  helper(0)
  return resultSet
}

const nums_1 = [1,2,3]
console.log(subsetsWithDup(nums_1))

const nums_2 = [1,2,2]
console.log(subsetsWithDup(nums_2))