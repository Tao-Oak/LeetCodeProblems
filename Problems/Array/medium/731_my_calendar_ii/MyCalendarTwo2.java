//
// Created by Joshua.Cao, 2018/10/27
//
// https://leetcode.com/problems/my-calendar-ii/
//
import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo2 {
  List<int[]> books = new ArrayList<>();
  List<int[]> intersections = new ArrayList<>();

  // Accepted, beats 80.97%
  public boolean book(int start, int end) {
    for(int[] b: intersections) {
      if (Math.max(b[0], start) < Math.min(b[1], end)) {
        return false;
      }
    }
    for (int[] b: books) {
      int s = Math.max(b[0], start);
      int e = Math.min(b[1], end);
      if (s < e) {
        intersections.add(new int[] { s, e });
      }
    }
    books.add(new int[] { start, end });
    return true;
  }

  public static void main(String[] args) {
    MyCalendarTwo2 obj = new MyCalendarTwo2();
    int[][] input = {
      {10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}
    };
    for (int i = 0; i < input.length; i++) {
      System.out.println(obj.book(input[i][0], input[i][1]) + "\t");
    }
    System.out.println();

    MyCalendarTwo2 obj_2 = new MyCalendarTwo2();
    int[][] input_2 = {
      {24,40}, {43,50}, {27,43}, { 5,21}, {30,40},
      {14,29}, { 3,19}, { 3,14}, {25,39}, { 6,19}
    };
    for (int i = 0; i < input_2.length; i++) {
      System.out.println(obj_2.book(input_2[i][0], input_2[i][1]) + "\t");
    }
  }
}