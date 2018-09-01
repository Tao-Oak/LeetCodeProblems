//
// Created by CaoTao, 2018/09/01
//

function partition(nums, low, high) {
  if (low === high) {
    return
  }
  var pivot = nums[low]
  var i = low + 1, j = high

  while (j >= i) {
    if (nums[j] >= pivot) {
      j--
      continue
    }

    nums[i - 1] = nums[j]
    nums[j] = nums[i]
    nums[i] = pivot
    i++
  }
  return i - 1
}

function quickSortRecursive(nums, low, high) {
  if (low >= high) {
    return
  }
  var middle = partition(nums, low, high)
  quickSortRecursive(nums, low, middle - 1)
  quickSortRecursive(nums, middle + 1, high)
}

function quickSortWhileLoop(nums, low, high) {
  if (low >= high) return
  let stack = []
  stack.push([low, high])
  while (stack.length > 0) {
    let boundary = stack.pop()
    let left = boundary[0], right = boundary[1]

    let medium = partition(nums, left, right)
    if (medium - 1 > left) {
      stack.push([left, medium - 1])
    }
    if (medium + 1 < right) {
      stack.push([medium + 1, right])
    }
  }
}