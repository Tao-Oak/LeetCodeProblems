//
// Created by Joshua.cao, 2018/09/23
//
// https://leetcode.com/problems/subsets-ii/description/
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    return result;
  }

  public void backtrack() {
    
  }

  public void printResult(List<List<Integer>> result) {
    for (List<Integer> subset: result) {
      System.out.println(subset);
    }
  }

  public static void main(String[] args) {
    SubsetsTwo obj = new SubsetsTwo();
    int[] input = {1, 2, 2};
    obj.printResult(obj.subsetsWithDup(input));

    int[] input_2 = {5,5,5,5,5};
    obj.printResult(obj.subsetsWithDup(input_2));
  }
}