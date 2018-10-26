//
// Created by Joshua.cao, 2018/10/14
//
// https://leetcode.com/problems/majority-element-ii/
//

function majorityElement(nums) {
  if (!nums || nums.length <= 0) {
    return []
  }
  let maximum1, maximum2, counter1 = 0, counter2 = 0
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === maximum1) {
      counter1++
    } else if (nums[i] === maximum2) {
      counter2++
    } else if (counter1 === 0) {
      maximum1 = nums[i]
      counter1++
    } else if (counter2 === 0) {
      maximum2 = nums[i]
      counter2++
    } else {
      counter1--
      counter2--
    }
  }
  counter1 = 0
  counter2 = 0
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === maximum1) {
      counter1++
    } else if (nums[i] === maximum2) {
      counter2++
    }
  }
  let result = []
  let threshold = Math.floor(nums.length / 3)
  if (counter1 > threshold) {
    result.push(maximum1)
  }
  if (counter2 > threshold) {
    result.push(maximum2)
  }
  return result
}

// Accepted, linear time, O(n) space, beats 89.41%
function majorityElement_2(nums) {
  let map = {}, result = []
  for (let i = 0; i < nums.length; i++) {
    if (map[nums[i]] === undefined) {
      map[nums[i]] = 1
    } else {
      map[nums[i]] = map[nums[i]] + 1
    }
  }
  let threshold = nums.length / 3
  Object.keys(map).forEach(propKey => {
    if (map[propKey] > threshold) {
      result.push(propKey * 1)
    }
  })
  return result
}

const input_1 = [3,2,3]
const input_2 = [1,1,1,3,3,2,2,2]
console.log(majorityElement(input_1))
console.log(majorityElement(input_2))