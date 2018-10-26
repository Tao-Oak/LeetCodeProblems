//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/set-matrix-zeroes/description/
// 
import java.util.Arrays;

public class SetMatrixZero {
  // Cannot handle boundary case
  public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    if (rows <= 0) return;
    int columns = matrix[0].length;
    if (columns <= 0) return;

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = columns - 1; j >= 0; j--) {
        if (matrix[i][j] == 0) {
          for (int k = i; k < rows; k++) {
            matrix[k][j] = 0;
          }
          for (int k = j; k < columns; k++) {
            matrix[i][k] = 0;
          }
        }
      }
    }
    printMatrix(matrix);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (isZeroPoint(matrix, i, j)) {
          fillWithZero(matrix, i, j);
          break;
        }
      }
    }
  }

  private boolean isZeroPoint (int[][] matrix, int i, int j) {
    boolean zeroPoint = true;
    if (matrix[i][j] != 0) {
      zeroPoint = false;
    }
    if (i - 1 > 0 && matrix[i - 1][j] == 0) {
      zeroPoint = false;
    }
    if (j - 1 > 0 && matrix[i][j - 1] == 0) {
      zeroPoint = false;
    }
    return zeroPoint;
  }

  private void fillWithZero(int[][] matrix, int row, int column) {
    for (int i = 0; i < row; i++) {
      matrix[i][column] = 0;
    }
    for (int i = 0; i < column; i++) {
      matrix[row][i] = 0;
    }
  }

  // Accepted: Beats 100%
  public void setZeroes_2(int[][] matrix) {
    int rows = matrix.length;
    if (rows <= 0) return;
    int columns = matrix[0].length;
    if (columns <= 0) return;

    boolean setFirstRow = false;
    boolean setFirstColumn = false;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) {
            setFirstRow = true;
          }
          if (j == 0) {
            setFirstColumn = true;
          }
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < columns; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < rows; j++) {
          matrix[j][i] = 0;
        }
      }
    }
    for (int i = 1; i < rows; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < columns; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    if (setFirstRow) {
      for (int i = 0; i < columns; i++) {
        matrix[0][i] = 0;
      }
    }
    if (setFirstColumn) {
      for (int j = 1; j < rows; j++) {
        matrix[j][0] = 0;
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
    SetMatrixZero obj = new SetMatrixZero();
    int[][] matrix_1 = {
      {0,1,2,0},
      {3,4,5,2},
      {1,3,1,5}
    };
    obj.setZeroes_2(matrix_1);
    obj.printMatrix(matrix_1);

    int[][] matrix_2 = {
      {1,1,1},
      {1,0,1},
      {1,1,1}
    };
    obj.setZeroes_2(matrix_2);
    obj.printMatrix(matrix_2);

    int[][] matrix_3 = {
      {4, 9, 8, 1, 1, 1},
      {5, 1, 1, 1, 1, 1},
      {8, 1, 1, 1, 0, 1},
      {0, 1, 1, 1, 1, 1}
    };
    obj.setZeroes_2(matrix_3);
    obj.printMatrix(matrix_3);
  }
}

// {0, 9, 8, 1, 0, 1},
// {0, 1, 1, 1, 0, 1},
// {0, 0, 0, 0, 0, 0},
// {0, 0, 0, 0, 0, 0}