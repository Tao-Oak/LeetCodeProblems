//
// Created by Joshua.cao, 2018/10/29
//
// https://leetcode.com/problems/friends-of-appropriate-ages/
//
import java.util.Arrays;

public class FriendsOfAppropriateAges {

  // Accepted, beats 44.17%
  public int numFriendRequests(int[] ages) {
    int counter = 0;
    int[] numInAge = new int[121];
    int[] sumInAge = new int[121];
    for (int age: ages) {
      numInAge[age]++;
    }
    for (int i = 1; i < 121; i++) {
      sumInAge[i] = numInAge[i] + sumInAge[i - 1];
    }
    for (int i = 15; i < 121; i++) {
      if (numInAge[i] == 0) continue;
      int count = sumInAge[i] - sumInAge[i / 2 + 7];
      counter += count * numInAge[i] - numInAge[i];
    }
    return counter;
  }

  // Accepted, beats 21.54%
  public int numFriendRequests_2(int[] ages) {
    int counter = 0;
    if (ages.length <= 1) return 0;
    Arrays.sort(ages);
    // System.out.println(Arrays.toString(ages));
    int temp = 0;
    for (int i = ages.length - 1; i >= 0; i--) {
      if (i + 1 < ages.length && ages[i] == ages[i + 1]) {
        counter += temp;
        continue;
      }
      double threshold = ages[i] * 0.5 + 7;
      int index = binarySearch(ages, 0, i - 1, threshold);
      
      temp = i - 1 - index;
      // System.out.println("i: " + i + ", index: " + index + ", temp: " + temp);
      counter += temp;
    }
    return counter;
  }

  // find the maximum index i that meets nums[i] <= target
  private int binarySearch(int[] nums, int left, int right, double target) {
    if (left > right) return right;
    if (nums[left] > target) return left - 1;
    if (nums[right] < target) return right;

    // left <= right && nums[left] <= target <= nums[right]  
    if (nums[right] == target) return right;
    for (int i = right - 1; i > left; i--) {
      if (nums[i] != nums[i + 1]) break;
      right--;
    }
    for (int i = left + 1; i < right; i++) {
      if (nums[i] != nums[i - 1]) break;
      left++;
    }
    if (nums[left] == target) return left;

    // left <= right && nums[left] < target < nums[right]
    int middle = (left + right) / 2;
    for (int i = middle + 1; i <= right; i++) {
      if (nums[i] != nums[middle]) {
        break;
      }
      middle++;
    }
    if (nums[middle + 1] <= target) {
      return binarySearch(nums, middle + 1, right, target);
    } else if (nums[middle] >= target) {
      return binarySearch(nums, left, middle, target);
    } else {
      return middle;
    }
  }

  // Accepted, beats 13.82%
  public int numFriendRequests_3(int[] ages) {
    int counter = 0;
    if (ages.length <= 1) return 0;
    Arrays.sort(ages);

    int temp = 0;
    for (int i = ages.length - 1; i >= 0; i--) {
      if (i + 1 < ages.length && ages[i] == ages[i + 1]) {
        counter += temp;
        continue;
      }
      temp = 0;
      double threshold = ages[i] * 0.5 + 7;
      for (int j = i - 1; j >= 0; j--) {
        if (ages[j] <= threshold) break;
        temp++;
      }
      counter += temp;
    }
    return counter;
  }

  public void printResult(int[] ages) {
    System.out.println(numFriendRequests(ages));
  }
  public static void main(String[] args) {
    FriendsOfAppropriateAges obj = new FriendsOfAppropriateAges();
    obj.printResult(new int[] { 16, 16 });
    obj.printResult(new int[] { 16, 17, 18 });
    obj.printResult(new int[] { 20, 30, 100, 110, 120 });
    obj.printResult(new int[] {
      22, 22, 24, 26, 30, 35, 36, 37, 53, 58, 69, 70, 81, 99, 109
    });
    obj.printResult(new int[] {
        6,   8,  12,  12,  12,  13,  15,  21,  23,  27,
       28,  29,  31,  34,  36,  38,  40,  44,  51,  53,
       57,  57,  58,  64,  65,  65,  69,  71,  75,  76,
       76,  77,  78,  78,  82,  90,  96,  97,  97,  97,
      100, 101, 105, 106, 106, 109, 113, 117, 117, 119
    });
  }
}