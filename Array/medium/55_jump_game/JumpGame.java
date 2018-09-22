//
// Created by Joshua.cao, 2018/09/16
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/jump-game/description/
 */

public class JumpGame {
  // timeout soultion
  public boolean canJump(int[] nums) {
    int length = nums.length;
    if (length <= 1) return true;
    return backtrack(nums, length - 1, 0);
  }

  public boolean backtrack(int nums[], int remain, int current) {
    boolean result = false;
    if (nums[current] >= remain) {
      result = true;
      return result;
    }
    if (nums[current] == 0) {
      return result;
    }
    for (int i = 1; i <= nums[current]; i++) {
      if (backtrack(nums, remain - i, current + i)) {
        result = true;
        break;
      }
    }
    return result;
  }

  public boolean canJump_2(int[] nums) {
    int nearest = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= nearest) {
        nearest = i;
      }
    }
    return nearest == 0;
  }

  public static void main(String[] args) {
    JumpGame obj = new JumpGame();
    // System.out.println(obj.canJump(new int[]{0}));
    // System.out.println(obj.canJump(new int[]{2,3,1,1,4}));
    // System.out.println(obj.canJump(new int[]{3,2,1,0,4}));
    // System.out.println(obj.canJump(new int[]{1, 2, 3}));
    System.out.println(obj.canJump(new int[]{2, 0, 0}));
  }
}