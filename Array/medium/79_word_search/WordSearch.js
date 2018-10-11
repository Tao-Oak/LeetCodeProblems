//
// Created by CaoTao, 2018/10/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/word-search/description/
 */
function exist(board, word) {
  const rows = board.length
  const columns = board[0].length

  function helper(row, column, start) {
    if (start === word.length) {
      return true
    }
    if (row < 0 || row >= rows || column < 0 || column >= columns) {
      return false
    }
    if (word[start] !== board[row][column]) {
      return false
    }
    board[row][column] = ''
    if (helper(row - 1, column, start + 1)) {
      return true
    }
    if (helper(row, column + 1, start + 1)) {
      return true
    }
    if (helper(row + 1, column, start + 1)) {
      return true
    }
    if (helper(row, column - 1, start + 1)) {
      return true
    }
    board[row][column] = word[start]
    return false
  }
  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < columns; j++) {
      if (helper(i, j, 0)) return true
    }
  }
  return false
}

function exist_2(board, word) {
  const wordLength = word.length
  const row = board.length
  const column = board[0].length
  let charArray = []
  for (let i = 0; i < wordLength; i++) {
    charArray.push(word.charAt(i))
  }
  let existed = false
  for (let i = 0; i < row; i++) {
    for (let j = 0; j < column; j++) {
      if (helper(board, charArray, row, column, wordLength, i, j, 0)) {
        existed = true
        break
      }
    }
  }
  return existed
}

function helper(board, word, row, column, wordLength, rowIndex, columnIndex, start) {
  if (start === wordLength) {
    return true
  }
  if (rowIndex < 0 || rowIndex >= row || columnIndex < 0 || columnIndex >= column) {
    return false
  }
  if (word[start] !== board[rowIndex][columnIndex]) {
    return false
  }
  let temp = board[rowIndex][columnIndex]
  board[rowIndex][columnIndex] = ''
  let founded = helper(board, word, row, column, wordLength, rowIndex - 1, columnIndex, start + 1)
  if (!founded) {
    founded = helper(board, word, row, column, wordLength, rowIndex, columnIndex + 1, start + 1)
  }
  if (!founded) {
    founded = helper(board, word, row, column, wordLength, rowIndex + 1, columnIndex, start + 1) 
  }
  if (!founded) {
    founded = helper(board, word, row, column, wordLength, rowIndex, columnIndex - 1, start + 1)
  }
  board[rowIndex][columnIndex] = temp
  return founded
}

const board = [
  ['A', 'B', 'C', 'E'],
  ['S', 'F', 'C', 'S'],
  ['A', 'D', 'E', 'E']
]
const word_1 = 'ABCCED'
const word_2 = 'SEE'
const word_3 = 'ABCB'
console.log(exist(board, word_1))
console.log(exist(board, word_2))
console.log(exist(board, word_3))
console.log(exist([['a']], 'b'))