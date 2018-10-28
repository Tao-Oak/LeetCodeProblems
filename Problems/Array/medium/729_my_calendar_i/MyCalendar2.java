//
// Created by Joshua.Cao, 2018/10/26
//
// https://leetcode.com/problems/my-calendar-i/
//
import java.util.ArrayList;
import java.util.List;

public class MyCalendar2 {
  private List<int[]> nodes = new ArrayList<>();

  public boolean book(int start, int end) {
    for (int[] b: nodes) {
      if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
    }
    nodes.add(new int[]{ start, end });
    return true;
  }
}