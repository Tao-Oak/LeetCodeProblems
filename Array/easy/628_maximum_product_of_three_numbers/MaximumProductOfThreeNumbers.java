//
// Created by CaoTao, 2018/08/19
//

/*
 * LeetCode link:
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 */
import java.lang.Math;

public class MaximumProductOfThreeNumbers {
  private int partition(int[] nums, int low, int high) {
    if (low >= high) return low;
    int pivot = nums[low];
    int left = low + 1, right = high;
    while (left <= right) {
      if (nums[right] > pivot) {
        right--;
        continue;
      }
      nums[left - 1] = nums[right];
      nums[right] = nums[left];
      nums[left] = pivot;
      left++;
    }
    return left - 1;
  }

  private void quickSort(int[] nums, int low, int high) {
    if (low >= high) return;
    int middle = partition(nums, low, high);
    quickSort(nums, low, middle - 1);
    quickSort(nums, middle + 1, high);
  }


  public int maximumProduct(int[] nums) {
    int length = nums.length;
    quickSort(nums, 0, length - 1);
    return Math.max(
      nums[0] * nums[1] * nums[length - 1],
      nums[length - 1] * nums[length - 2] * nums[length - 3]
    );
  }
  public static void main(String[] args) {
    MaximumProductOfThreeNumbers obj = new MaximumProductOfThreeNumbers();
    int product = obj.maximumProduct(new int[]{-1,-2,-3});
    System.out.println("maximumProduct of [-1,-2,-3] is " + product);
  }
}