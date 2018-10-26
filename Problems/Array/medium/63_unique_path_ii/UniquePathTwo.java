import java.util.Arrays;

//
// Created by Joshua.cao, 2018/09/22
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/unique-paths-ii/description/
 */

public class UniquePathTwo {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rows = obstacleGrid.length;
    if (rows <= 0) return 0;
    int columns = obstacleGrid[0].length;
    if (columns <= 0) return 0;

    int[][] grid = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      }
      grid[i][0] = 1;
    }
    for (int i = 0; i < columns; i++) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
      grid[0][i] = 1;
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < columns; j++) {
        if (obstacleGrid[i][j] == 1) {
          grid[i][j] = 0;
          continue;
        }
        grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
      }
    }

    return grid[rows - 1][columns - 1];
  }

  public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
    int rows = obstacleGrid.length;
    if (rows <= 0) return 0;
    int columns = obstacleGrid[0].length;
    if (columns <= 0) return 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (i == 0 || j == 0) {
          if (i == 0 && j != 0 && obstacleGrid[i][j - 1] == 0) {
            obstacleGrid[i][j] = 0;
          } else if (j == 0 && i != 0 && obstacleGrid[i - 1][j] == 0) {
            obstacleGrid[i][j] = 0;
          } else {
            obstacleGrid[i][j] ^= 1;
          }
          continue;
        }
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
          continue;
        }
        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
      }
    }
    return obstacleGrid[rows - 1][columns - 1];
  }

  public void printArray(int[][] grid) {
    int rows = grid.length;
    for (int i = 0; i < rows; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }
  }

  public static void main(String[] args) {
    UniquePathTwo obj = new UniquePathTwo();
    System.out.println("result: " + obj.uniquePathsWithObstacles(new int[][]{
      {0, 0, 0},{0, 1, 0},{0, 0, 0}
    }));

    System.out.println("result_2: " + obj.uniquePathsWithObstacles_2(new int[][]{
      {0, 0, 0},{0, 1, 0},{0, 0, 0}
    }));
    System.out.println("result_2_1: " + obj.uniquePathsWithObstacles_2(new int[][]{
      {0}
    }));
    System.out.println("result_2_2: " + obj.uniquePathsWithObstacles_2(new int[][]{
      {1}, {0}
    }));
  }
}