import java.util.Arrays;

//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
//

public class RemoveDuplicates {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int counter = 1;
    int currentIndex = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        if (counter < 2) {
          nums[currentIndex++] = nums[i];
        }
        counter++;
      } else {
        counter = 1;
        nums[currentIndex++] = nums[i];
      }
    }
    return currentIndex;
  }

  public static void main(String[] args) {
    RemoveDuplicates obj = new RemoveDuplicates();
    int[] input = {1,1,1,2,2,3};
    int length = obj.removeDuplicates(input);
    System.out.println("length: " + length + ", " + Arrays.toString(input));

    int[] input_2 = {0,0,1,1,1,1,2,3,3};
    int length_2 = obj.removeDuplicates(input_2);
    System.out.println("length_2: " + length_2 + ", " + Arrays.toString(input_2));
  }
}