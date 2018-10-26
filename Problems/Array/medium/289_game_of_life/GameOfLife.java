//
// Created by Joshua.cao, 2018/10/20
//
// https://leetcode.com/problems/game-of-life/
//
import java.util.Arrays;

public class GameOfLife {
  // Accepted, beats 75.22%, without extra space
  public void gameOfLife(int[][] board) {
    int rows = board.length;
    int columns = board[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        int lives = liveNeighbors(board, rows, columns, i, j);
        if ((board[i][j] & 1) == 1) {
          if (lives == 2 || lives == 3) {
            board[i][j] = 3;
          }
        } else {
          if (lives == 3) board[i][j] = 2;
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        board[i][j] >>= 1;
      }
    }
  }

  public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
    int counter = 0;
    for (int row = i - 1; row <= i + 1; row++) {
      if (row < 0 || row >= m) continue;
      for (int column = j - 1; column <= j + 1; column++) {
        if (column < 0 || column >= n) {
          continue;
        }
        if ((board[row][column] & 1) == 1) counter++;
      }
    }
    if ((board[i][j] & 1) == 1) counter--;
    return counter;
  }


  // Accepted, beats 100%
  public void gameOfLife_2(int[][] board) {
    int rows = board.length;
    int columns = board[0].length;
    int[][] copy = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        copy[i][j] = board[i][j];
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        int liveNeighborsCount = getLiveNeighborsCount(copy, i, j);
        if (board[i][j] == 1) {
          if (liveNeighborsCount < 2 || liveNeighborsCount > 3) {
            board[i][j] = 0;
          }
        } else {
          if (liveNeighborsCount == 3) {
            board[i][j] = 1;
          }
        }
      }
    }
  }

  public int getLiveNeighborsCount(int[][] board, int row, int column) {
    int rows = board.length;
    int columns = board[0].length;
    int counter = 0;
    if (row - 1 >= 0 && board[row - 1][column] == 1) {
      counter++;
    }
    if (row - 1 >= 0 && column + 1 < columns && board[row - 1][column + 1] == 1) {
      counter++;
    }
    if (column + 1 < columns && board[row][column + 1] == 1) {
      counter++;
    }
    if (row + 1 < rows && column + 1 < columns && board[row + 1][column + 1] == 1) {
      counter++;
    }
    if (row + 1 < rows && board[row + 1][column] == 1) {
      counter++;
    }
    if (row + 1 < rows && column - 1 >= 0 && board[row + 1][column - 1] == 1) {
      counter++;
    }
    if (column - 1 >= 0 && board[row][column - 1] == 1) {
      counter++;
    }
    if (row - 1 >= 0 && column - 1 >= 0 && board[row - 1][column - 1] == 1) {
      counter++;
    }
    return counter;
  }

  public void printBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      System.out.println(Arrays.toString(board[i]));
    }
  }

  public static void main(String[] args) {
    GameOfLife obj = new GameOfLife();
    int[][] board = {
      {0,1,0},
      {0,0,1},
      {1,1,1},
      {0,0,0}
    };
    obj.gameOfLife(board);
    obj.printBoard(board);
  }
}