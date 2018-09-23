import java.util.Arrays;

//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/sort-colors/description/
//

public class SortColors {
  public void sortColors(int[] nums) {
    int length = nums.length;
    if (length <= 1) return;
    int redIndex = 0;
    int whiteIndex = 0;
    int blueIndex = length - 1;
    while (whiteIndex <= blueIndex) {
      if (nums[whiteIndex] == 1) {
        whiteIndex++;
      } else if (nums[whiteIndex] == 0) {
        nums[whiteIndex] = 1;
        nums[redIndex++] = 0;
        whiteIndex++;
      } else {
        nums[whiteIndex] = nums[blueIndex];
        nums[blueIndex--] = 2;
      }
    }
  }

  public static void main(String[] args) {
    SortColors obj = new SortColors();
    int[] input = {2,0,2,1,0,2,1,1,1,1,0};
    obj.sortColors(input);
    System.out.println(Arrays.toString(input));
  }
}