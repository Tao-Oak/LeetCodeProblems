//
// Created by CaoTao, 2018/09/16
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 */

import java.util.Arrays;;

public class SpiralMatrixTwo {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];

    int offset = 0, currentValue = 1;
    while(n > 0) {
      for (int i = 0; i < n; i++) {
        matrix[offset][offset + i] = currentValue++;
      }
      for (int i = 1; i < n; i++) {
        matrix[offset + i][offset + n - 1] = currentValue++;
      }
      for (int i = n - 2; n > 1 && i >= 0; i--) {
        matrix[offset + n - 1][offset + i] = currentValue++;
      }
      for (int i = n - 2; n > 1 && i > 0; i--) {
        matrix[offset + i][offset] = currentValue++;
      }
      offset++;
      n -= 2;
    }

    return matrix;
  }

  private void printMatrix (int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    SpiralMatrixTwo obj = new SpiralMatrixTwo();
    int[][] matrix = obj.generateMatrix(5);
    obj.printMatrix(matrix);
  }
}