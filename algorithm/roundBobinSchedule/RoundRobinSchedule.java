//
// Created by Joshua.cao, 2018/10/20
//
// https://www.geeksforgeeks.org/program-round-robin-scheduling-set-1/
//

public class RoundRobinSchedule {
  public int[] findWaitingTime(int[] processes, int n, int[] bt, int quantum) {
    int[] waitingTime = new int[n];
    int[] remainingTime = new int[n];
    for (int i = 0; i < n; i++) {
      remainingTime[i] = bt[i];
    }
    int currentTime = 0;
    while(true) {
      boolean finished = true;
      for (int i = 0; i < n; i++) {
        if (remainingTime[i] <= 0) continue;
        finished = false;
        if (remainingTime[i] > quantum) {
          remainingTime[i] -= quantum;
          currentTime += quantum;
        } else {
          currentTime += remainingTime[i];
          waitingTime[i] = currentTime - bt[i];
          remainingTime[i] = 0;
        }
      }
      if (finished) break;
    }
    return waitingTime;
  }

  public int[] findTurnAroundTime(int[] bt, int[] wt, int n) {
    int[] tat = new int[n];
    for (int i = 0; i < n; i++) {
      tat[i] = wt[i] + bt[i];
    }
    return tat;
  }

  public void findAvgTime(int[] processes, int[] bt, int n, int quantum) {
    int[] wt = findWaitingTime(processes, n, bt, quantum);
    int[] tat = findTurnAroundTime(bt, wt, n);
    float totalWaitingTime = 0, totalTurnAroundTime = 0;
    System.out.println("p\tbt\twt\ttat");
    for (int i = 0; i < n; i++) {
      totalWaitingTime += wt[i];
      totalTurnAroundTime += tat[i];
      System.out.format("%d\t%d\t%d\t%d\n", i + 1, bt[i], wt[i], tat[i]);
    }
    System.out.println("Average waiting time = " + totalWaitingTime / n);
    System.out.println("Average turn around time = " + totalTurnAroundTime / n);
  }

  public static void main(String[] args) {
    RoundRobinSchedule obj = new RoundRobinSchedule();
    int[] processes = {1, 2, 3};
    int[] brustTime = {10, 5, 8};
    int quantum = 2;
    obj.findAvgTime(processes, brustTime, processes.length, quantum);
  }
}