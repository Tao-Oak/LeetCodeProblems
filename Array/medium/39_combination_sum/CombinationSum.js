//
// Created by CaoTao, 2018/10/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/combination-sum/description/
 */
function combinationSum(candidates, target) {
  let length = candidates.length
  Array.prototype.sort.call(candidates, (a, b) => {
    return a - b
  })
  let resultList = [], tempList = []
  helper(candidates, target, 0, length, tempList, resultList)
  return resultList
}

function helper(candidates, target, start, length, tempList, resultList) {
  if (target === 0) {
    resultList.push([...tempList])
    return
  }

  for (let i = start; i < length; i++) {
    if (candidates[i] > target) {
      break
    }
    tempList.push(candidates[i])
    helper(candidates, target - candidates[i], i, length, tempList, resultList)
    tempList.pop()
  }
}

// let nums = [2,3,6,7];
// console.log(combinationSum(nums, 7))

// let nums2 = [2,3,5];
// console.log(combinationSum(nums2, 8))

let nums3 = [3,12,9,11,6,7,8,5,4]
console.log(combinationSum(nums3, 15))
// [
//   [3,3,3,3,3],
//   [3,3,3,6],
//   [3,3,4,5],
//   [3,3,9],
//   [3,4,4,4],
//   [3,4,8],
//   [3,5,7],
//   [3,6,6],
//   [3,12],
//   [4,4,7],
//   [4,5,6],
//   [4,11],
//   [5,5,5],
//   [6,9],
//   [7,8]
// ]