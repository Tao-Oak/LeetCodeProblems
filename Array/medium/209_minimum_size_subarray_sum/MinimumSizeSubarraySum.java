//
// Created by Joshua.cao, 2018/10/13
//
// https://leetcode.com/problems/minimum-size-subarray-sum/
//

public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    int left = 0;
    int right = left;
    int sum = 0;
    while (right < nums.length) {
      sum += nums[right];
      if (sum >= s) {
        minLength = Math.min(minLength, right - left + 1);
      }
      while (sum >= s) {
        sum -= nums[left];
        left++;
        if (sum >= s) {
          minLength = Math.min(minLength, right - left + 1);
        }
      }
      right++;
    }
    if (minLength == Integer.MAX_VALUE) {
      minLength = 0;
    }
    return minLength;
  }
  
  // Accepted, beats 7.01%
  public int minSubArrayLen_2(int s, int[] nums) {
    int minLen = nums.length + 1;
    for (int i = 0; i < nums.length; i++) {
      int subarrayLen = helper(nums, s, i);
      if (subarrayLen == 1) {
        minLen = 1;
        break;
      }
      if (subarrayLen < minLen) {
        minLen = subarrayLen;
      }
    }
    return minLen > nums.length ? 0 : minLen;
  }

  public int helper(int nums[], int target, int start) {
    int minLen = nums.length + 1;
    int sum = 0;
    for (int i = start; i < nums.length; i++) {
      sum += nums[i];
      if (sum >= target) {
        minLen = i - start + 1;
        break;
      }
    }
    return minLen;
  }

  public static void main(String[] args) {
    MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
    int[] input_1 = {2,3,1,2,4,3};
    System.out.println(obj.minSubArrayLen(7, input_1));
  }
}