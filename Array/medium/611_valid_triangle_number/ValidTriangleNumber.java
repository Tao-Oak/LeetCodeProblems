//
// Created by Joshua.cao, 2018/10/22
//
// https://leetcode.com/problems/valid-triangle-number/
//
import java.util.Arrays;

public class ValidTriangleNumber {
  public int triangleNumber(int[] nums) {
    int counter = 0;
    Arrays.sort(nums);
    for (int i = nums.length - 1; i >= 2; i--) {
      int left = 0, right = i - 1;
      while (left < right) {
        if (nums[left] + nums[right] > nums[i]) {
          counter += right - left;
          right--;
        } else {
          left++;
        }
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    ValidTriangleNumber obj = new ValidTriangleNumber();
    int[] input = {2,2,3,4};
    System.out.println(obj.triangleNumber(input));
  }
}