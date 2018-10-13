//
// Created by Joshua.cao, 2018/10/12
//
// https://leetcode.com/problems/triangle/description/
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.List;

public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int leftCost = triangle.get(i + 1).get(j);
        int rightCost = triangle.get(i + 1).get(j + 1);
        int cost = Math.min(leftCost, rightCost);
        cost += triangle.get(i).get(j);
        triangle.get(i).set(j, cost);
      }
    }
    return triangle.get(0).get(0);
  }

  public List<List<Integer>> transform(int[][] input) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int[] row: input) {
      List<Integer> temp = new ArrayList<>();
      for (int value: row) {
        temp.add(value);
      }
      triangle.add(temp);
    }
    return triangle;
  }


  public static void main(String[] args) {
    int[][] triangle = {
      {2},
      {3,4},
      {6,5,7},
      {4,1,8,3}
    };
    int[][] triangle_2 = {
      {-1},
      { 9,-2},
      { 0, 4, 5},
      { 7, 4,-4,-5},
      { 9, 6, 0, 5, 7},
      { 9, 2,-9,-4, 5,-2},
      {-4,-9,-5,-7,-5,-5,-2},
      {-9, 5,-6,-4, 4, 1, 6,-4},
      {-4, 3, 9,-2, 8, 6,-9,-2,-2},
      { 7,-6, 9, 8,-4, 2,-4,-2,-1,-2},
      { 0, 3, 2, 4, 0,-6, 7, 6, 7,-5, 2},
      { 9, 0,-8, 6, 4, 6, 2, 5,-9, 9,-1,-6},
      { 6,-3,-4,-5, 0, 3, 3, 4,-6,-4,-7, 7, 3}
    };
    Triangle obj = new Triangle();
    System.out.println(obj.minimumTotal(obj.transform(triangle)));
    System.out.println(obj.minimumTotal(obj.transform(triangle_2)));
  }
}