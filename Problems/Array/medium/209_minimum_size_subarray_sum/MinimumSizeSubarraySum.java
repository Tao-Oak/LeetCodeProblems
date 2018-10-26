//
// Created by Joshua.cao, 2018/10/13
//
// https://leetcode.com/problems/minimum-size-subarray-sum/
//
// Related Problems: ['713 Subarray product Less Than K']
//

public class MinimumSizeSubarraySum {
  // Accepted, beats 55.35%
  public int minSubArrayLen(int s, int[] nums) {
    int left = 0, sum = 0;
    int minLen = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];
      if (sum >= s) minLen = Math.min(minLen, right - left + 1);
      while(sum >= s && left <= right) {
        sum -= nums[left++];
        if (sum >= s) {
          minLen = Math.min(minLen, right - left + 1);
        }
      }
    }
    if (minLen == Integer.MAX_VALUE) minLen = 0;
    return minLen;
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
    System.out.println(obj.minSubArrayLen_3(7, input_1));
  }
}