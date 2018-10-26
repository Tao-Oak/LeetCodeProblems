//
// Created by Joshua.cao, 2018/10/14
//
// https://leetcode.com/problems/combination-sum-iii/
//
import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> currentSet = new ArrayList<>();
    helper(resultList, currentSet, 0, k, n);

    return resultList;
  }

  public void helper(List<List<Integer>> resultList,
        List<Integer> currentSet, int start, int k, int remain) {
    if (remain == 0 && currentSet.size() == k) {
      resultList.add(new ArrayList<>(currentSet));
      return;
    }
    if (start >= 9) return;

    for (int i = start; i < 9; i++) {
      if (i + 1 > remain) break;
      currentSet.add(i + 1);
      helper(resultList, currentSet, i + 1, k, remain - i - 1);
      currentSet.remove(new Integer(i + 1));
    }
  }

  public static void main(String[] args) {
    CombinationSumThree obj = new CombinationSumThree();
    // System.out.println(obj.combinationSum3(3, 7));
    // System.out.println(obj.combinationSum3(3, 9));
    System.out.println(obj.combinationSum3(3, 15));
  }
}