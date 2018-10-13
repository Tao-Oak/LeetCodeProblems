//
// Created by Joshua.cao, 2018/10/13
//
// https://leetcode.com/problems/maximum-product-subarray/
//

public class MaximumProductSubarray {
  // Accepted, beats 99.93%
  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int productMax = 1;
    int productMin = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 0) {
        max = Math.max(max, 0);
        productMax = productMin = 1;
        continue;
      }
      productMax *= nums[i];
      productMin *= nums[i];
      if (productMin > productMax) {
        int temp = productMax;
        productMax = productMin;
        productMin = temp;
      }
      if (productMax > max) {
        max = productMax;
      }
      if (productMax < 0) {
        productMax = 1;
      }
    }
    return max;
  }

  // Accpeted, beats 1.47%
  public int maxProduct_2(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int product = helper(nums, i);
      if (product > max) {
        max = product;
      }
    }
    return max;
  }

  public int helper(int[] nums, int start) {
    if (nums[start] == 0) return 0;
    int product = nums[start];
    int max = nums[start];
    for (int i = start + 1; i < nums.length; i++) {
      if (nums[i] == 0) break;
      product *= nums[i];
      if (product > max) {
        max = product;
      }
    }
    return max;
  }
  public static void main(String[] args) {
    MaximumProductSubarray obj = new MaximumProductSubarray();
    int[] input_1 = {2,3,-2,4};
    int[] input_2 = {-2,0,-1};
    System.out.println(obj.maxProduct(input_1));
    System.out.println(obj.maxProduct(input_2));
  }
}