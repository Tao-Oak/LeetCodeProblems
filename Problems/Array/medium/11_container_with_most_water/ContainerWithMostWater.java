//
// Created by CaoTao, 2018/08/19
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/container-with-most-water/description/
 */
import java.lang.Math;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    if (height.length == 2) {
      return Math.min(height[0], height[1]);
    }

    int result = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int area = (j - i) * Math.min(height[i], height[j]);
        if (area > result) {
          result = area;
        }
      }
    }
    return result;
  }

  public int maxArea2(int[] height) {
    int max = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      int area;
      if (height[left] > height[right]) {
        area = height[right] * (right - left);
        right--;
      } else {
        area = height[left] * (right - left);
        left++;
      }
      if (area > max) max = area;
    }
    return max;
  }

  public static void main(String[] args) {
    ContainerWithMostWater obj = new ContainerWithMostWater();
    int area = obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    System.out.println("maxArea is: " + area);
  }
}