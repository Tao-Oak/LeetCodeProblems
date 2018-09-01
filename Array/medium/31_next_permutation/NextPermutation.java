//
// Created by CaoTao, 2018/09/01
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/next-permutation/description/
 */
import java.util.Arrays;

public class NextPermutation {
  public void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  public void reverse(int[] nums, int start, int end) {
    while(start < end){
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  public void nextPermutation(int[] nums) {
    int first = -1, number = -1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        first = i;
        break;
      }
    }
    if (first != -1) {
      for (int i = nums.length - 1; i > first; i--) {
        if (nums[i] > nums[first]) {
          number = i;
          break;
        }
      }
      swap(nums, first, number);
    }
    reverse(nums, first + 1, nums.length - 1);
  }

  public static void main(String[] args) {
    NextPermutation obj = new NextPermutation();
    // int[] nums = {1, 2, 3, 4, 5, 6};
    // int[] nums = {6, 5, 4, 3, 2, 1};
    int[] nums = {6, 3, 4, 9, 8, 7, 1};
    obj.nextPermutation(nums);
    // obj.reverse(nums, 4, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }
}