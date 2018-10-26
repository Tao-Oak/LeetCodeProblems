//
// Created by Joshua.cao, 2018/10/13
//
// https://leetcode.com/problems/summary-ranges/
//
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
  // Accepted, beats 60.13%
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<>();
    if (nums.length <= 0) return ranges;
    int startIndex = 0, i = 1;
    for (; i < nums.length; i++) {
      if (nums[i] - 1 == nums[i - 1]) continue;
      if (i - 1 == startIndex) {
        ranges.add(nums[startIndex] + "");
      } else {
        ranges.add(nums[startIndex] + "->" + nums[i - 1]);
      }
      startIndex = i;
    }
    if (i - 1 == startIndex) {
      ranges.add(nums[startIndex] + "");
    } else {
      ranges.add(nums[startIndex] + "->" + nums[i - 1]);
    }
    return ranges; 
  }

  public static void main(String[] args) {
    SummaryRanges obj = new SummaryRanges();
    int[] input_1 = {0,1,2,4,5,7};
    int[] input_2 = {0,2,3,4,6,8,9};
    System.out.println(obj.summaryRanges(input_1));
    System.out.println(obj.summaryRanges(input_2));
  }
}