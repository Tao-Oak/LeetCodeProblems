//
// Created by Joshua.Cao, 2018/10/26
//
// https://leetcode.com/problems/my-calendar-i/
//
public class MyCalendar {
  static class Range {
    int start, end;
    Range left, right;
    Range(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  Range root;
  public MyCalendar() {}
  
  // Accepted, beats 57.67%
  public boolean book(int start, int end) {
    if (end < start) return false;
    Range n = insert(root, start, end);
    if (n == null) return false;
    root = n;
    return true;
  }

  private Range insert(Range parent, int start, int end) {
    if (parent == null) {
      return new Range(start, end);
    }
    if (end <= parent.start) {
      Range left = insert(parent.left, start, end);
      if (left == null) return null;
      parent.left = left;
    } else if (start >= parent.end) {
      Range right = insert(parent.right, start, end);
      if (right == null) return null;
      parent.right = right;
    } else {
      return null;
    }
    return parent;
  }

  public static void main(String[] args) {
    MyCalendar obj = new MyCalendar();
    int[][] input = {{10, 20}, {15, 25}, {20, 30}};
    for (int i = 0; i < input.length; i++) {
      System.out.print(obj.book(input[i][0], input[i][1]) + "\t");
    }
    System.out.println();

    MyCalendar obj_2 = new MyCalendar();
    int[][] input_2 = {
      {47, 50}, {33, 41}, {39, 45}, {33, 42}, {25, 32},
      {26, 35}, {19, 25}, { 3,  8}, { 8, 13}, {18, 27}
    };
    for (int i = 0; i < input_2.length; i++) {
      System.out.print(obj_2.book(input_2[i][0], input_2[i][1]) + "\t");
    }
    System.out.println();
  }
}