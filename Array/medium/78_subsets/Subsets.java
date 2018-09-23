//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/subsets/description/
//
import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    int length = nums.length;
    if (length <= 0) {
      return result;
    }

    for (int i = 0; i < length; i++) {
      List<List<Integer>> temp = copyResult(result);
      for (List<Integer> subset: temp) {
        subset.add(nums[i]);
      }
      result.addAll(temp);
    }

    return result;
  }

  private List<List<Integer>> copyResult(List<List<Integer>> input) {
    List<List<Integer>> result = new ArrayList<>(input.size());
    for (List<Integer> subset: input) {
      result.add(new ArrayList<>(subset));
    }
    return result;
  }

  private void printResult(List<List<Integer>> result) {
    for (List<Integer> subset: result) {
      System.out.println(subset);
    }
  }

  public static void main(String[] args) {
    Subsets obj = new Subsets();
    int[] input = {1, 2, 3};
    obj.printResult(obj.subsets(input));
  }
}