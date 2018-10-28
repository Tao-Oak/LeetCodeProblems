//
// Created by Joshua.Cao, 2018/10/27
//
// https://leetcode.com/problems/my-calendar-ii/
//

public class MyCalendarTwo {
  static class Range {
    int intersects;
    int start, end;
    Range left, right;
    Range(int start, int end, int intersects) {
      this.start = start;
      this.end = end;
      this.intersects = intersects;
    }
  }
  private Range root;
  
  public boolean book(int start, int end) {
    if (!canInsert(root, start, end)) {
      return false;
    }
    root = insert(root, start, end);
    return true;
  }

  public boolean canInsert(Range parent, int start, int end) {
    if (parent == null) return true;
    if (end <= parent.start) {
      return canInsert(parent.left, start, end);
    } else if (start >= parent.end) {
      return canInsert(parent.right, start, end);
    } else {
      if (parent.intersects >= 2) return false;
      if (start < parent.start && !canInsert(parent.left, start, parent.start)) {
        return false;
      }
      if (end > parent.end && !canInsert(parent.right, parent.end, end)) {
        return false;
      }
      return true;
    }
  }

  public Range insert(Range parent, int start, int end) {
    if (parent == null) {
      return new Range(start, end, 1);
    }
    if (end <= parent.start) {
      parent.left = insert(parent.left, start, end);
    } else if (start >= parent.end) {
      parent.right = insert(parent.right, start, end);
    } else {
      if (start < parent.start) {
        parent.left = insert(parent.left, start, parent.start);
      }
      if (end > parent.end) {
        parent.right = insert(parent.right, parent.end, end);
      }
      if (start > parent.start) {
        Range left = new Range(parent.start, start, parent.intersects);
        left.left = parent.left;
        parent.left = left;
        parent.start = start;
      }
      if (end < parent.end) {
        Range right = new Range(end, parent.end, parent.intersects);
        right.right = parent.right;
        parent.right = right;
        parent.end = end;
      }
      parent.intersects++;
    }
    return parent;
  }

  public static void main(String[] args) {
    MyCalendarTwo obj = new MyCalendarTwo();
    int[][] input = {
      {10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}
    };
    for (int i = 0; i < input.length; i++) {
      System.out.println(obj.book(input[i][0], input[i][1]) + "\t");
    }
    System.out.println();

    MyCalendarTwo obj_2 = new MyCalendarTwo();
    int[][] input_2 = {
      {24,40}, {43,50}, {27,43}, { 5,21}, {30,40},
      {14,29}, { 3,19}, { 3,14}, {25,39}, { 6,19}
    };
    for (int i = 0; i < input_2.length; i++) {
      System.out.println(obj_2.book(input_2[i][0], input_2[i][1]) + "\t");
    }
  }
}