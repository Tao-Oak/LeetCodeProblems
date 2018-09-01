//
// Created by CaoTao, 2018/09/01
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/3sum-closest/description/
 */
import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    int minDiff = Integer.MAX_VALUE;
    int result = nums[0] + nums[1] + nums[3];
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      if (nums[i] * 3 > target) {
        int temp = nums[i] + nums[i + 1] + nums[i + 2];
        if (temp - target < minDiff) {
          minDiff = temp - target;
          result = temp;
        }
      }
      if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
        int temp2 = nums[i] + nums[nums.length - 1] + nums[nums.length - 2];
        if (target - temp2 < minDiff) {
          minDiff = target - temp2;
          result = temp2;
        }
        continue;
      }
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        // System.out.println("left: " + left + ", right: " + right);
        if (left > i + 1 && nums[left - 1] == nums[left]) {
          left++;
          continue;
        }
        if (right < nums.length - 1 && nums[right + 1] == nums[right]) {
          right--;
          continue;
        }
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == target) {
          return sum;
        } else if (sum > target) {
          if (sum - target < minDiff) {
            minDiff = sum - target;
            result = sum;
          }
          right--;
        } else if (sum < target) {
          if (target - sum < minDiff) {
            minDiff = target - sum;
            result = sum;
          }
          left++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ThreeSumClosest obj = new ThreeSumClosest();
    System.out.println(obj.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
  }
}