//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/search-a-2d-matrix/description/
// 

public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    if (rows <= 0) return false;
    int columns = matrix[0].length;
    if (columns <= 0) return false;

    if (target < matrix[0][0] || target > matrix[rows - 1][columns - 1]) {
      return false;
    }
    int [] firstColumns = new int[rows];
    for (int i = 0; i < rows; i++) {
      firstColumns[i] = matrix[i][0];
    }
    int targetRow = findTargetRow(firstColumns, target);
    System.out.println("targetRow: " + targetRow);
    if (targetRow == -1) {
      return false;
    }
    int targetColumn = findTargetIndex(matrix[targetRow], target, 0, columns - 1);
    return targetColumn != -1;
  }

  private int findTargetRow(int[] firstColumns, int target) {
    int length = firstColumns.length;
    if (target >= firstColumns[length - 1]) {
      return length - 1;
    }
    int targetRow = -1;
    for (int i = 1; i < length; i++) {
      if (target >= firstColumns[i - 1] && target < firstColumns[i]) {
        targetRow = i - 1;
        break;
      }
    }
    return targetRow;
  }

  private int findTargetIndex(int[] nums, int target, int left, int right) {
    if (right < left) {
      return -1;
    }
    if (target > nums[right] || target < nums[left]) {
      return -1;
    }

    int middle = (left + right) / 2;
    if (target == nums[middle]) {
      return middle;
    } else if (target < nums[middle]) {
      return findTargetIndex(nums, target, left, middle - 1);
    } else {
      return findTargetIndex(nums, target, middle + 1, right);
    }
  }

  public static void main(String[] args) {
    Search2DMatrix obj = new Search2DMatrix();
    int[][] matrix = {
      {1,   3,  5,  7},
      {10, 11, 16, 20},
      {23, 30, 34, 50}
    };
    System.out.println("result: " + obj.searchMatrix(matrix, 51));

    int[][] matrix_2 = {
      {1}
    };
    System.out.println("result_2: " + obj.searchMatrix(matrix_2, 1));
  }
}