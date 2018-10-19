//
// Created by Joshua.cao, 2018/10/20
//
// https://leetcode.com/problems/array-nesting/
//
public class ArrayNesting {
  public int arrayNesting(int[] nums) {
    int maxLength = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) continue;
      int counter = 0;
      int index = i;
      while(nums[index] >= 0) {
        counter++;
        int temp = nums[index];
        nums[index] = -1;
        index = temp;
      }
      if (counter > maxLength) {
        maxLength = counter;
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    ArrayNesting obj = new ArrayNesting();
    int[] input = {5,4,0,3,1,6,2};
    System.out.println(obj.arrayNesting(input));
  }
}