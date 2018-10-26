//
// Created by Joshua.cao, 2018/09/18
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/unique-paths/description/
 */
import java.util.List;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UniquePath {
  class Pair {
    int first;
    int second;
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  // DFS: Time Limit Exceeded
  public int uniquePaths(int m, int n) {
    int result = 0;
    if (m == 0 && n == 0) return result;
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(0, 0));
    while (stack.size() > 0) {
      Pair current = stack.pop();
      int row = current.first;
      int column = current.second;
      if (row == n - 1 && column == m - 1) {
        result++;
        continue;
      }
      if (row + 1 < n) {
        stack.push(new Pair(row + 1, column));
      }
      if (column + 1 < m) {
        stack.push(new Pair(row, column + 1));
      }
    }
    return result;
  }

  // BFS and DP: Accepted but very slow soultion
  public int uniquePaths_2(int m, int n) {
    int buffer[][] = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        buffer[i][j] = -1;
      }
    }

    Queue<Integer[]> queue = new LinkedList<>();
    queue.offer(new Integer[] {n - 1, m - 1});

    while (queue.peek() != null) {
      Integer[] current = queue.poll();
      int row = current[0], column = current[1];
      if (buffer[row][column] != -1) {
        continue;
      }

      // calculate path count
      int pathCount = 0;  
      if (row + 1 < n) {
        pathCount += buffer[row + 1][column];
      }
      if (column + 1 < m) {
        pathCount += buffer[row][column + 1];
      }
      if (row == n - 1 && column == m - 1) {
        pathCount = 1;
      }
      buffer[row][column] = pathCount;

      // expand parent node
      int top = row - 1;
      if (top >= 0) {
        queue.offer(new Integer[] {top, column});
      }
      int left = column - 1;
      if (left >= 0) {
        queue.offer(new Integer[] {row, left});
      }
    }
    return buffer[0][0];
  }

  public int uniquePaths_3(int m, int n) {
    int grid[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
      grid[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      grid[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
      }
    }
    return grid[m - 1][n - 1];
  }

  public static void main(String[] args) {
    UniquePath obj = new UniquePath();
    int result = obj.uniquePaths(7, 3);
    System.out.println("result: " + result);
    System.out.println("result 2: " + obj.uniquePaths_2(7, 3));
    System.out.println("result 3: " + obj.uniquePaths_3(7, 3));
  }
}