//
// Created by Joshua.cao, 2018/10/17
//
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
//
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] < 0) {
        result.add(index + 1);
      } else {
        nums[index] = -nums[index];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    FindAllDuplicates obj = new FindAllDuplicates();
    int[] input = {4,3,2,7,8,2,3,1};
    System.out.println(obj.findDuplicates(input));
  }
}