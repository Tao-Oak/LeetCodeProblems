//
// Created by Joshua.cao, 2018/10/14
//
// https://leetcode.com/problems/majority-element-ii/
//
import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums.length <= 0) return result;
    int counter1 = 0, counter2 = 0;
    int maximum1 = -1, maximum2 = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == maximum1) {
        counter1++;
      } else if (nums[i] == maximum2) {
        counter2++;
      } else if (counter1 == 0) {
        maximum1 = nums[i];
        counter1++;
      } else if (counter2 == 0) {
        maximum2 = nums[i];
        counter2++;
      } else {
        counter1--;
        counter2--;
      }
    }
    counter1 = counter2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == maximum1) {
        counter1++;
      } else if (nums[i] == maximum2) {
        counter2++;
      }
    }

    int threshold = nums.length / 3;
    if (counter1 > threshold) {
      result.add(maximum1);
    }
    if (counter2 > threshold) {
      result.add(maximum2);
    }
    return result;
  }

  public static void main(String[] args) {
    MajorityElementTwo obj = new MajorityElementTwo();
    int[] input_1 = {3,2,3};
    int[] input_2 = {1,1,1,3,3,2,2,2};
    System.out.println(obj.majorityElement(input_1));
    System.out.println(obj.majorityElement(input_2));
  }
}