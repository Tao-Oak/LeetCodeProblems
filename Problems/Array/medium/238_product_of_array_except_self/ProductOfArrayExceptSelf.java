//
// Created by Joshua.cao, 2018/10/14
//
// https://leetcode.com/problems/product-of-array-except-self/
//
import java.util.Arrays;

public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      // use this line, beats 100%
      // result[i] = nums[i - 1] * result[i - 1];
      
      // use this line, beats 45.81%
      result[i] = result[i - 1] * nums[i - 1];
    }
    int rightProduct = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      result[i] *= nums[i + 1] * rightProduct;
      rightProduct *= nums[i + 1];
    }
    return result;
  }

  // Accepted, beats 45.81%
  public int[] productExceptSelf_2(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }
    for (int i = nums.length - 2; i >=0; i--) {
      result[i] *= nums[i + 1];
      nums[i] *= nums[i + 1];
    }
    return result;
  }

  // Accepted, beats 13.29%
  public int[] productExceptSelf_3(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }
    for (int i = nums.length - 2; i >=0; i--) {
      result[i] = result[i] * nums[i + 1];
      nums[i] = nums[i] * nums[i + 1];
    }
    return result;
  }

  public static void main(String[] args) {
    ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
    int[] input = {1,2,3,4,6};
    System.out.println(Arrays.toString(obj.productExceptSelf(input)));
  }
}