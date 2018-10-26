//
// Created by CaoTao, 2018/03/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/can-place-flowers/description/
 */

/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */

/**
 * Cannot work, it is hard to handle boundary condition
 * 
 * Some boundary condition case:
 * flowerbed = [0], n = 1
 * flowerbed = [0, 0, 0], n = 2
 */ 
var canPlaceFlowers = function(flowerbed, n) {
  var length = flowerbed.length
  var start = end = -1, canPlaceCount = 0

  if (length === 1 && flowerbed[0] === 0 && n === 1) {
    return true
  }

  for (var i = 0; i < length; i++) {
    if (flowerbed[i] === 0) {
      end = i
      if (start === -1) {
        start = i
      }
    } else {
      var diff = end - start
      if ((start === 0 || end === length - 1) && diff % 2 !== 0) {
        diff += 1
      }
      console.log(`start: ${start} end: ${end} diff: ${diff}`)
      canPlaceCount += Math.floor(diff / 2)
      start = end = -1
    }
  }
  var diff = end - start
  if ((start === 0 || end === length - 1) && diff % 2 !== 0) {
    diff += 1
  }
  console.log(`start: ${start} end: ${end} diff: ${diff}`)
  canPlaceCount += Math.floor(diff / 2)
  return canPlaceCount >= n
};

var canPlaceFlowers = function(flowerbed, n) {
  var length = flowerbed.length, canPlaceCount = 0

  var preview, next
  for (var i = 0; i < length; i++) {
    if (flowerbed[i] === 1) continue
    preview = i === 0 ? 0 : flowerbed[i - 1]
    next = i === length - 1 ? 0 : flowerbed[i + 1]
    if (preview === 0 && next === 0) {
      canPlaceCount++
      flowerbed[i] = 1
    }
  }
  return canPlaceCount >= n
}