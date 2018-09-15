//
// Created by Joshua.cao, 2018/09/16
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/spiral-matrix/description/
 */

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int offset = 0;
    int rows = matrix.length;
    if (rows <= 0) return result;
    int columns = matrix[0].length;

    while (rows > 0 && columns > 0) {
      for (int i = 0; i < columns; i++) {
        result.add(matrix[offset][offset + i]);
      }
      for (int i = 1; i < rows; i++) {
        result.add(matrix[offset + i][offset + columns - 1]);
      }
      for (int i = columns - 2; i >= 0 && rows > 1; i--) {
        result.add(matrix[offset + rows - 1][offset + i]);
      }
      for (int i = rows - 2; i > 0 && columns > 1; i--) {
        result.add(matrix[offset + i][offset]);
      }
      offset++;
      rows -= 2;
      columns -= 2;
    }
    return result;
  }

  public static void main(String[] args) {
    SpiralMatrix obj = new SpiralMatrix();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> result = obj.spiralOrder(matrix);
    System.out.println(result);

    int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    List<Integer> result2 = obj.spiralOrder(matrix2);
    System.out.println(result2);
  }
}