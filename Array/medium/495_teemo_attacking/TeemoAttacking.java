//
// Created by Joshua.cao, 2018/10/19
//
// https://leetcode.com/problems/teemo-attacking/
//
public class TeemoAttacking {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int length = timeSeries.length;
    if (length <= 0) return 0;
    if (length == 1) return duration;
    int poisonedTime = 0;
    for (int i = 1; i < length; i++) {
      if (timeSeries[i - 1] + duration <= timeSeries[i]) {
        poisonedTime += duration;
      } else {
        poisonedTime += timeSeries[i] - timeSeries[i - 1];
      }
    }
    poisonedTime += duration;
    return poisonedTime;
  }

  public static void main(String[] args) {
    TeemoAttacking obj = new TeemoAttacking();
    System.out.println(obj.findPoisonedDuration(new int[]{1,4}, 2));
    System.out.println(obj.findPoisonedDuration(new int[]{1,2}, 2));
  }
}