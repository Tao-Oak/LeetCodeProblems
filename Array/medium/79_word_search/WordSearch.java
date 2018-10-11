import java.util.Arrays;

//
// Created by CaoTao, 2018/10/11
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/word-search/description/
 */

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (helper(board, w, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean helper(char[][] board, char[] word, int row, int column, int start) {
    // System.out.println("row: " + row + ", column: " + column + ", start: " + start);
    // printBoard(board);
    if (start == word.length) return true;
    if (row < 0 || row >= board.length) return false;
    if (column < 0 || column >= board[0].length) return false;
    if (board[row][column] != word[start]) return false;

    board[row][column] = '*';
    if (helper(board, word, row - 1, column, start + 1)) {
      return true;
    }
    if (helper(board, word, row, column + 1, start + 1)) {
      return true;
    }
    if (helper(board, word, row + 1, column, start + 1)) {
      return true;
    }
    if (helper(board, word, row, column - 1, start + 1)) {
      return true;
    }
    board[row][column] = word[start];
    return false;
  }

  public void printBoard(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      System.out.println(Arrays.toString(board[i]));
    }
  }

  public char[][] copyBoard(char[][] board) {
    char[][] newBoard = new char[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        newBoard[i][j] = board[i][j];
      }
    }
    return newBoard;
  }

  public static void main(String[] args) {
    WordSearch obj = new WordSearch();
    char[][] board = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
    };
    String word_1 = "ABCCED";
    String word_2 = "SEE";
    String word_3 = "ABCB";
    System.out.println(obj.exist(obj.copyBoard(board), word_1));
    System.out.println(obj.exist(obj.copyBoard(board), word_2));
    System.out.println(obj.exist(obj.copyBoard(board), word_3));
    System.out.println(obj.exist(new char[][]{{'a'}}, "b"));
  }
}