//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
//
public class SearchRotatedArrayTwo {
  public boolean search_3(int[] nums, int target) {
    if (nums.length <= 0) return false;
    int left = 0, right = nums.length - 1;
    return helper(nums, left, right, target);
  }

  public boolean helper(int[] nums, int left, int right, int target) {
    if (left >= right) {
      return nums[left] == target;
    }
    int middle = (left + right) / 2;

    if (nums[left] <= nums[middle] && nums[middle + 1] > nums[right]) {
      // left side is ordered and right side not
      if (nums[left] <= target && nums[middle] >= target) {
        return helper(nums, left, middle, target);
      } else {
        return helper(nums, middle + 1, right, target);
      }
    } else if (nums[left] > nums[middle] && nums[middle + 1] <= nums[right]) {
      // right side is ordered and left side not
      if (nums[middle + 1] <= target && target <= nums[right]) {
        return helper(nums, middle + 1, right, target);
      } else {
        return helper(nums, left, middle, target);
      }
    } else {
      boolean hasFound = helper(nums, left, middle, target);
      if (hasFound) return hasFound;
      return helper(nums, middle + 1, right, target);
    }
  }


  // Accepted: Beats 100%
  public boolean search_2(int[] nums, int target) {
    boolean found = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        found = true;
        break;
      }
    }
    return found;
  }

  public boolean search(int[] nums, int target) {
    if (nums.length == 1) {
      return nums[0] == target;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      //int mid = left + (right -  left) / 2;
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
          return true;
      }
      if (nums[left] > nums[mid] || nums[mid] < nums[right]) {
        //right part of array is sorted ascending
        if (target >  nums[mid] && target <= nums[right]) {
          //target is in right part of array (sorted)
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else if (nums[left] < nums[mid] || nums[mid] > nums[right]) {
        //left part of array is sorted ascending
        if (target < nums[mid] && target >= nums[left]) {
          right = mid - 1;
        } else{
          left = mid + 1;
        }
      } else {
        left++;
        right--;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    SearchRotatedArrayTwo obj = new SearchRotatedArrayTwo();
    int[] input_1 = {2,5,6,0,0,1,2};
    System.out.println(obj.search(input_1, 0));

    System.out.println(obj.search(input_1, 3));

    int[] input_2 = {1};
    System.out.println(obj.search(input_2, 0));

    int[] input_3 = {1,3,1,1,1};
    System.out.println(obj.search(input_3, 3));

    int[] input_4 = {3,1,1};
    System.out.println(obj.search(input_4, 3));
  }
}