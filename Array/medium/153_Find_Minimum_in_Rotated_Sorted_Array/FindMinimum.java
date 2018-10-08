//
// Created by Joshua.cao, 2018/09/26
//
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
//

public class FindMinimum {
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    return helper(nums, left, right);
  }

  public int helper(int[] nums, int left, int right) {
    int middle = (left + right) / 2;
    if (left >= right) return nums[left];
    if (nums[left] <= nums[middle] && nums[middle + 1] <= nums[right]) {
      return Math.min(nums[left], nums[middle + 1]);
    } else if (nums[left] > nums[middle] && nums[middle + 1] <= nums[right]) {
      return helper(nums, left, middle);
    } else {
      return helper(nums, middle + 1, right);
    }
  }

  public int findMin_2(int[] nums) {
    int minimum = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < minimum) {
        minimum = nums[i];
      }
    }
    return minimum;
  }

  public static void main(String[] args) {
    FindMinimum obj = new FindMinimum();
    int[] input_1 = {3,4,5,1,2};
    System.out.println(obj.findMin(input_1));

    int[] input_2 = {4,5,6,7,0,1,2};
    System.out.println(obj.findMin(input_2));

    int[] input_3 = {3,4,5,6,7,1,2};
    System.out.println(obj.findMin(input_3));

    int[] input_4 = {6,7,1,2,3,4,5};
    System.out.println(obj.findMin(input_4));

    int[] input_5 = {4,5,6,7,1,2,3};
    System.out.println(obj.findMin(input_5));

    int[] input_6 = {5, 4};
    System.out.println(obj.findMin(input_6));

    int[] input_7 = {4};
    System.out.println(obj.findMin(input_7));
  }
}