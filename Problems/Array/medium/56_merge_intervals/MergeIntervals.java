//
// Created by CaoTao, 2018/09/16
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/merge-intervals/description/
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Interval {
  int start;
  int end;
  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }

  @Override
  public String toString() {
    return "[" + start + ", " + end + "]";
  }
}

public class MergeIntervals {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<>();

    intervals.sort(new Comparator<Interval>() {
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    Interval current = null;
    for (Interval interval: intervals) {
      if (current != null && current.end >= interval.start) {
        current = new Interval(current.start, Math.max(current.end, interval.end));
      } else {
        if (current != null) {
          result.add(current);
        }
        current = interval;
      } 
    }
    if (current != null) {
      result.add(current);
    }
    
    return result; 
  }

  private List<Interval> geneIntervals(int[][] input) {
    List<Interval> result = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      result.add(new Interval(input[i][0], input[i][1]));
    }
    return result;
  }

  public static void main(String[] args) {
    MergeIntervals obj = new MergeIntervals();
    int[][] input = {{1,3},{2,6},{8,10},{15,18}};
    List<Interval> result = obj.merge(obj.geneIntervals(input));
    System.out.println(result);


    int[][] input2 = {{1,4},{4,5},{8,10},{15,18}};
    List<Interval> result2 = obj.merge(obj.geneIntervals(input2));
    System.out.println(result2);
  }
}