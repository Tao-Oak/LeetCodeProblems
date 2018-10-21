//
// Created by Joshua.cao, 2018/10/20
//
// https://leetcode.com/problems/subarray-sum-equals-k/
//
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
  // Accepted, beats 89.04%
  public int subarraySum(int[] nums, int k) {
    int sum = 0;
    int counter = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) counter++;
      Integer temp = map.get(sum - k);
      if (temp != null) counter += temp;
      temp = map.get(sum);
      if (temp == null) {
        map.put(sum, 1);
      } else {
        map.put(sum, temp + 1);
      }
    }

    return counter;
  }

  // Accepted, beats 19.54%
  public int subarraySum_2(int[] nums, int k) {
    int counter = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) {
          counter++;
        }
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    SubarraySumEqualsK obj = new SubarraySumEqualsK();
    System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
    System.out.println(obj.subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
    System.out.println(obj.subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
  }
}