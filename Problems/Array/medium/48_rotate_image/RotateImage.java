//
// Created by CaoTao, 2018/09/14
//
import java.util.*;
/*
 * LeetCode link:
 * https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    if (n <= 1) return;
    int middle = n / 2;
    // System.out.println("middle: " + middle);
    for (int column = 0; column < middle; column++) {
      int top = column, down = n - 1 - column;
      // System.out.println("top: " + top + ", down: " + down);
      for (int row = top; row < down; row++) {
        // System.out.println("row: " + row);
        int i = row, j = column;
        int next_i, next_j, temp;
        int current = matrix[i][j];
        do {
          next_i = j;
          next_j = n - 1 - i;
          temp = matrix[next_i][next_j];
          matrix[next_i][next_j] = current;
          current = temp;
          i = next_i;
          j = next_j;
          // System.out.println("current: " + current);
          printMatrix(matrix);
        } while (i != row || j != column);
      }
    }
  }

  public void rotate_2(int[][] matrix) {
    int n = matrix.length;
    if (n <= 1) return;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = temp;
      }
    }
  }

  private void printMatrix (int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    RotateImage obj = new RotateImage();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    obj.rotate_2(matrix);
    obj.printMatrix(matrix);
    
    int[][] matrix_2 = {
      { 5,  1,  9, 11},
      { 2,  4,  8, 10},
      {13,  3,  6,  7},
      {15, 14, 12, 16}
    };
    obj.rotate_2(matrix_2);
    obj.printMatrix(matrix_2);
  }
}