//
// Created by CaoTao, 2018/10/12
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/combination-sum-ii/description/
 */

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
  Array.prototype.sort.call(candidates, (a, b) => a - b)
  let tempArray = []
  let result = []

  // console.log('...candidates:', candidates)
  function helper(target, start) {
    if (target === 0) {
      result.push([...tempArray])
      return
    }

    for (let i = start; i < candidates.length; i++) {
      if (candidates[i] > target) return
      if (i != start && candidates[i] === candidates[i - 1]) {
        continue
      }
      tempArray.push(candidates[i])
      helper(target - candidates[i], i + 1)
      tempArray.pop()
    }
  }
  helper(target, 0)
  return result
}

console.log(combinationSum2([10,1,2,7,6,1,5], 8))
console.log(combinationSum2([2,5,2,1,2], 5))