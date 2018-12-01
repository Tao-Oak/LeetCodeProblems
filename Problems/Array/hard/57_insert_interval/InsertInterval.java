//
// Created by Joshua.Cao, 2018/11/13
//
// https://leetcode.com/problems/insert-interval/
//
import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the 
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their 
 * start times.
 * 
 * Example 1:
 *   Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 *   Output: [[1,5],[6,9]]
 * 
 * Example 2:
 *   Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 *   Output: [[1,2],[3,10],[12,16]]
 *   Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],
 *   [8,10].
*/
class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }

  @Override
  public String toString() {
    return "[" + start + ", " + end + "]";
  }
}

public class InsertInterval {
  // Accepted, beats 93.73%
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<>();

    boolean inserted = false;
    for (int i = 0; i < intervals.size(); i++) {
      Interval inter = intervals.get(i);
      
      if (!inserted && newInterval.end < inter.start) {
        result.add(newInterval);
        result.add(inter);
        inserted = true;
      } else if (!inserted && newInterval.start <= inter.end) {
        Interval temp = new Interval();
        temp.start = Math.min(inter.start, newInterval.start);
        temp.end = Math.max(inter.end, newInterval.end);
        result.add(temp);
        inserted = true;
      } else if (inserted) {
        Interval first = result.remove(result.size() - 1);
        if (first.end >= inter.start) {
          Interval temp = new Interval();
          temp.start = Math.min(inter.start, first.start);
          temp.end = Math.max(inter.end, first.end);
          result.add(temp);
        } else {
          result.add(first);
          result.add(inter);
        }
      } else {
        result.add(inter);
      }
    }
    if (!inserted) result.add(newInterval);

    return result;
  }

  public void test(int[][] intervals, int[] newInterval) {
    List<Interval> intervalList = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
    }
    Interval target = new Interval(newInterval[0], newInterval[1]);

    List<Interval> result = insert(intervalList, target);
    System.out.println(result);
  }

  public static void main(String[] args) {
    InsertInterval obj = new InsertInterval();
    int[] target_1 = {2, 5};
    int[][] input_1 = {{1, 3}, {6, 9}};

    int[] target_2 = {4, 8};
    int[][] input_2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};

    int[] target_3 = {1, 2};
    int[][] input_3 = {{6, 9}};

    int[] target_4 = {6, 9};
    int[][] input_4 = {{1, 2}};

    obj.test(input_1, target_1);
    obj.test(input_2, target_2);
    obj.test(input_3, target_3);
    obj.test(new int[0][0], target_3);
    obj.test(input_4, target_4);
  }
}