//
// Created by Joshua.cao, 2018/10/20
//
// https://leetcode.com/problems/task-scheduler/
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    int[] c = new int[26];
    for(char t : tasks){
      c[t - 'A']++;
    }
    Arrays.sort(c);
    int i = 25;
    while(i >= 0 && c[i] == c[25]) i--;

    return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
  }

  public static void main(String[] args) {
    TaskScheduler obj = new TaskScheduler();
    char [] tasks = {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'E', 'E', 'F', 'F', 'G', 'G'};
    System.out.println(obj.leastInterval(tasks, 2));
  }
}