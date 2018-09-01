//
// Created by CaoTao, 2018/09/01
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/4sum/description/
 */

var fourSum = function(nums, target) {
  let result = []
  let length = nums.length
  if (length < 4) return result
  nums.sort(function (a, b) { return a - b })
  //  console.log('sorted nums:', nums)

  for (let i = 0; i < length - 3; i++) {
    if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
      continue
    }
    if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
      continue
    }
    if (i > 0 && nums[i - 1] === nums[i]) {
      continue
    }
    let threeSumTarget = target - nums[i]
    // console.log('threeSumTarget:', threeSumTarget)
    for (let j = i + 1; j < length - 2; j++) {
      if (nums[j] + nums[j + 1] + nums[j + 2] > threeSumTarget) {
        continue
      }
      if (nums[j] + nums[length - 1] + nums[length - 1] < threeSumTarget) {
        continue
      }
      if (j > i + 1 && nums[j - 1] === nums[j]) {
        continue
      }
      let twoSumTarget = threeSumTarget - nums[j]
      console.log('twoSumTarget:', twoSumTarget)
      let left = j + 1, right = length - 1
      while (left < right) {
        if (left > j + 1 && nums[left - 1] == nums[left]) {
          left++
          continue
        }
        let sum = nums[left] + nums[right]
        if (sum > twoSumTarget) {
          right--
        } else if (sum < twoSumTarget) {
          left++
        } else {
          result.push([nums[i], nums[j], nums[left], nums[right]])
          right--
          left++
        }
      }
    }
  }
  return result
}



let result1 = fourSum([1, 0, -1, 0, -2, 2], 0)
console.log('result1:', result1)

let result2 = fourSum([0, 0, 0, 0], 0)
console.log('result2:', result2)

let result3 = fourSum([-1,0,1,2,-1,-4], -1)
console.log('result3:', result3)

let result4 = fourSum([1,-2,-5,-4,-3,3,3,5], -11)
console.log('result4:', result4)

let result5 = fourSum([2,1,0,-1], 2)
console.log('result5:', result5)