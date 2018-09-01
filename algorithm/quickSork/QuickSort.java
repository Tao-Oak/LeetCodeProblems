//
// Created by CaoTao, 2018/09/01
//
import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
  int partition (int[] nums, int low, int high) {
    if (low >= high) return high;
    int pivot = nums[low];
    int left = low + 1, right = high;

    while (left <= right) {
      if (nums[right] >= pivot) {
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

  void quickSortRecursive(int[] nums, int low, int high) {
    if (low >= high) return;

    int medium = partition(nums, low, high);
    quickSortRecursive(nums, low, medium - 1);
    quickSortRecursive(nums, medium + 1, high);
  }

  void quickSortWhileLoop(int[] nums, int low, int high) {
    if (low >= high) return;
    Stack<Integer[]> stack = new Stack<>();
    stack.push(new Integer[]{low, high});

    while (stack.size() > 0) {
      Integer[] boundary = stack.pop();
      int left = boundary[0], right = boundary[1];
      int medium = partition(nums, left, right);
      if (right > medium + 1) {
        stack.push(new Integer[]{medium + 1, high});
      }
      if (medium - 1 > left) {
        stack.push(new Integer[]{left, medium - 1});
      }
    }
  }

  public static void main(String[] args) {
    QuickSort obj = new QuickSort();
    int[] nums = {8, 3, 7, 9, 10};
    // obj.quickSortRecursive(nums, 0, 4);
    obj.quickSortWhileLoop(nums, 0, 4);
    System.out.println(Arrays.toString(nums));
  }
}