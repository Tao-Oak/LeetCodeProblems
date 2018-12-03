//
// Created by Joshua.Cao, 2018/12/02
//
// https://leetcode.com/problems/jump-game-ii/
//
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of non-negative integers, you are initially positioned at the 
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position. 
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 *   Input: [2,3,1,1,4]
 *   Output: 2
 *   Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 *   You can assume that you can always reach the last index.
 */
public class JumpGameTwo {
  public int jump(int[] nums) {
    int steps = 0, fastIdx = 0, curIdx = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      fastIdx = Math.max(fastIdx, i + nums[i]);
      if (i == curIdx) {
        steps++;
        curIdx = fastIdx;
      }
    }
    return steps;
  }

  // Accepted, beats 75.65%
  public int jump_1(int[] nums) {
    if (nums.length <= 1) return 0;
    
    int index = 0, steps = 0;
    int left = 0, right = nums[0];
    int tgrIdx = nums.length - 1;
    while (true) {
      steps++;
      if (nums[index] + index >= tgrIdx) {
        break;
      }
      int max = 0;
      for (int i = left + 1; i <= right; i++) {
        int nextIndex = i + nums[i];
        if (nextIndex > max) {
          index = i;
          max = nextIndex;
        }
      }
      left = right;
      right = max;
    }
    return steps;
  }
  
  // Time Limit Exceeded
  public int jump_2(int[] nums) {
    int tgrIdx = nums.length - 1;
    Map<Integer, Integer> stepsMap = new HashMap<>();
    stepsMap.put(tgrIdx, 0);
    for (int i = tgrIdx - 1; i >= 0; i--) {
      if (i + nums[i] >= tgrIdx) {
        stepsMap.put(i, 1);
      } else {
        int minStep = tgrIdx;
        for (int j = 1; j <= nums[i]; j++) {
          if (stepsMap.get(i + j) < minStep) {
            minStep = stepsMap.get(i + j);
          }
        }
        stepsMap.put(i, 1 + minStep);
      }
    }
    return stepsMap.get(0);
  }

  // Time Limit Exceeded
  public int jump_3(int[] nums) {
    return traceHelper(nums, nums.length - 1, 0, 0);
  }
  
  public int traceHelper(int[] nums, int tgrIdx, int curIdx, int steps) {
    if (curIdx == tgrIdx) {
      return steps;
    }
    if (curIdx + nums[curIdx] > tgrIdx) {
      return steps + 1;
    }

    int minStep = tgrIdx;
    for (int i = 1; i <= nums[curIdx]; i++) {
      int step = traceHelper(nums, tgrIdx, curIdx + i, steps + 1);
      if (step < minStep) minStep = step;
    }
    return minStep;
  }

  public int[] readInputFromFile() {
    try {
      FileInputStream fi = new FileInputStream("./LargeInput.txt");
      InputStreamReader isr = new InputStreamReader(fi, "UTF-8");
      BufferedReader br = new BufferedReader(isr);

      String currentLine;
      StringBuilder builder = new StringBuilder();
      while ((currentLine = br.readLine()) != null)  {
        builder.append(currentLine);
      }
      br.close();
      String[] strArr = builder.toString().split(",");
      int[] input = new int[strArr.length];
      for (int i = 0; i < strArr.length; i++) {
        input[i] = Integer.parseInt(strArr[i]);
      }
      return input;
    } catch (Exception e) {
      System.out.println(" ...error:" + e);
      return new int[]{};
    }
  }

  public void test(int[] nums) {
    System.out.println(jump(nums));
  }

  public static void main(String[] args) {
    JumpGameTwo obj = new JumpGameTwo();

    obj.test(new int[]{0});
    obj.test(new int[]{2,3,1,1,4});
    obj.test(obj.readInputFromFile());
    obj.test(new int[]{
      5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,
      5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5
    });
  }
}
