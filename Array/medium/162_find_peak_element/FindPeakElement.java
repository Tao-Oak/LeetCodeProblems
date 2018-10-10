//
// Created by Joshua.cao, 2018/10/09
//
// https://leetcode.com/problems/find-peak-element/description/
//

public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int length = nums.length;
    if (length == 1) {
      return 0;
    }
    return helper(nums, 0, length - 1, length);
  }

  public int helper(int[] nums, int left, int right, int length) {
    if (left + 1 >= right) {
      if (left == 0 && nums[left] > nums[right]) {
        return left;
      }
      if (right == length - 1 && nums[right] > nums[left]) {
        return right;
      }
      return -1;
    }
    int middle = (left + right) / 2;
    if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
      return middle;
    }
    int result = helper(nums, left, middle, length);
    if (result == -1) {
      result = helper(nums, middle, right, length);
    }
    return result;
  }

  // Accepted: Simple O(n) complexity
  public int findPeakElement_2(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        if (nums[i] > nums[i + 1]) {
          return i;
        }
      } else if (i + 1 == nums.length) {
        if (nums[i] > nums[i - 1])
          return i;
      } else {
        if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
          return i;
        }
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    FindPeakElement obj = new FindPeakElement();
    int[] input_1 = {1,2,1,3,5,6,4};
    System.out.println(obj.findPeakElement(input_1));
    int[] input_2 = {1,2,3,1};
    System.out.println(obj.findPeakElement(input_2));
    int[] input_3 = {1,1};
    System.out.println(obj.findPeakElement(input_3));
  }
}