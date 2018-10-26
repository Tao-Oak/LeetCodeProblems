//
// Created by Joshua.cao, 2018/10/15
//
// https://leetcode.com/problems/find-the-duplicate-number/
//

public class FindTheDuplicateNumber {
  // Accepted, beats 100%
  public int findDuplicate(int[] nums) {
    int slow = nums.length;
    int fast = slow;

    do {
      slow = nums[slow - 1];
      fast = nums[nums[fast - 1] - 1];
    } while (slow != fast);
    // System.out.println("slow = fast = " + slow);

    // why???
    slow = nums.length;
    while (slow != fast) {
      slow = nums[slow - 1];
      fast = nums[fast - 1];
    }

    return slow;
  }

  // Accepted, beats 0.99%
  public int findDuplicate_2(int[] nums) {
    int duplicated = -1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i != j && nums[i] == nums[j]) {
          duplicated = nums[i];
          break;
        }
      }
    }
    return duplicated;
  }

  public static void main(String[] args) {
    FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
    int[] input_1 = {1, 3, 4, 2, 2};
    int[] input_2 = {3, 1, 3, 4, 2};
    System.out.println(obj.findDuplicate(input_1));
    System.out.println(obj.findDuplicate(input_2));
  }
}