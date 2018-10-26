//
// Created by Joshua.Cao, 2018/10/26
//
// https://leetcode.com/problems/my-calendar-i/
//
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MyCalendar {
  static class Range {
    int start, end;
    Range(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  Set<Range> books;
  public MyCalendar() {
    books = new TreeSet<>(new Comparator<MyCalendar.Range>() {
      @Override
      public int compare(Range o1, Range o2) {
        return o1.start - o2.start;
      }
    });
  }
  
  public boolean book(int start, int end) {
    if (end < start) return false;

    books.add(new Range(start, end));
    return true;
  }

  public void printBooks() {
    for (Range range: books) {
      System.out.println("[" + range.start + ", " + range.end + ")");
    }
  }

  public static void main(String[] args) {
    MyCalendar obj = new MyCalendar();
    obj.book(10, 20);
    obj.book(15, 25);
    obj.book(20, 30);
    obj.printBooks();
  }
}