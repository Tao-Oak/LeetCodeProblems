//
// Created by CaoTao, 2018/03/13
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/3sum/description/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// Time Limit Exceeded
var threeSum = function(nums) {
  var length = nums.length
  if (length < 3) { return [] }

  var result = [], map = {}
  for (var i = 0; i < length - 2; i++) {
    var twoSum = 0 - nums[i], twoSumMap = {}
    for (var j = i + 1; j < length; j++) {
      if (twoSumMap[twoSum - nums[j]] === undefined) {
        twoSumMap[nums[j]] = true
        continue
      }

      twoSumMap[nums[j]] = true
      var temp = [nums[i], nums[j], -nums[i] - nums[j]]
      sortArray(temp)
      
      var key = temp.join('')
      if (!map[key]) {
        map[key] = true
        result.push(temp)
      }
    }
  }

  function sortArray(nums) {
    nums.sort(function (a, b) {
      if (a > b) return 1
      if (a < b) return -1
      return 0
    })
  }
  return result
};

// Time Limit Exceeded
var threeSum_2 = function(nums) {
  var length = nums.length
  if (length < 3) { return [] }

  nums.sort(function (a, b) {
    if (a > b) return 1
    if (a < b) return -1
    return 0
  })

  var result = [], map = {}
  for (var i = 0; i < length - 2; i++) {
    var twoSum = 0 - nums[i], twoSumMap = {}
    for (var j = i + 1; j < length; j++) {
      var targetIndex = twoSumMap[twoSum - nums[j]]
      if (targetIndex === undefined) {
        twoSumMap[nums[j]] = j
        continue
      }
      var temp
      twoSumMap[nums[j]] = j
      if (targetIndex > j) {
        temp = [nums[i], nums[j], nums[targetIndex]]
      } else {
        temp = [nums[i], nums[targetIndex], nums[j]]
      }
      
      var key = temp.join('')
      if (!map[key]) {
        map[key] = true
        result.push(temp)
      }
    }
  }
  return result
}

var threeSum_3 = function(nums) {
  var length = nums.length
  if (length < 3) { return [] }
  nums.sort(function (a, b) { return a - b })

  var result = []
  for (var i = 0; i < length - 2; i++) {
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue
    }
    var sum = -nums[i], low = i + 1, high = length - 1
    while (low < high) {
      var temp = nums[low] + nums[high]
      if (temp > sum) {
        high--
      } else if (temp < sum) {
        low++
      } else {
        result.push([nums[i], nums[low], nums[high]])
        while (low < high && nums[low] === nums[low + 1]) {
          low++
        }
        while(low < high && nums[high] === nums[high - 1]) {
          high--
        }
        low++
        high--
      }
    }
  }
  return result
}

var threeSum_4 = function (nums) {
  if (nums.count < 3) { return [] }
  nums.sort(function (a, b) { return a - b })
  // console.log('nums:', nums)

  var result = []
  for (var i = 0; i < nums.length - 2; i++) {
    if (nums[i] > 0) break
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue
    }
    var low = i + 1, high = nums.length - 1
    while (low < high) {
      var sum = nums[low] + nums[high]
      if (low > i + 1 && nums[low - 1] === nums[low]) {
        low++
        continue
      }
      // console.log(`low: ${low} high: ${high} sum: ${sum} nums[i]: ${nums[i]}`)
      if (sum > -nums[i]) {
        high--
      } else if (sum < -nums[i]) {
        low++
      } else {
        result.push([nums[i], nums[low], nums[high]])
        low++
        high--
      }
    }
  }
  return result
}

console.log(
  // threeSum_4([0, 0, 0]),
  // threeSum_4([0, 0, 0, 0]),
  // threeSum_4([-1, 0, 1, 2, -1, -4]),
  // threeSum_4([3,4,-2,-5,1,2,8,-3]),
  threeSum_4([-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0])
)