//
// Created by Joshua.cao, 2018/10/20
//
// https://leetcode.com/problems/task-scheduler/
//
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a non-negative integer, you could swap two digits at most once to get 
 * the maximum valued number. Return the maximum valued number you could get.
 */
public class MaximumSwap {
  /*
   * Use buckets to record the last position of digit 0 ~ 9 in this num.
   * 
   * Loop through the num array from left to right. For each position, we check
   * whether there exists a larger digit in this num (start from 9 to current 
   * digit). We also need to make sure the position of this larger digit is 
   * behind the current one. If we find it, simply swap these two digits and 
   * return the result.
   */
  public int maximumSwap(int num) {
    char[] digits = Integer.toString(num).toCharArray();
    int[] buckets = new int[10];
    for (int i = 0; i < digits.length; i++) {
      buckets[digits[i] - '0'] = i;
    }

    for (int i = 0; i < digits.length; i++) {
      for (int k = 9; k > (digits[i] - '0'); k--) {
        if (buckets[k] > i) {
          char temp = digits[i];
          digits[i] = digits[buckets[k]];
          digits[buckets[k]] = temp;
          return Integer.valueOf(new String(digits));
        }
      }
    }
    return num;
  }

  // Accepted, beats 58.39%
  public int maximumSwap_2(int num) {
    List<Integer> list = new ArrayList<>();
    splitNumber(num, list);
    Collections.reverse(list);
    // System.out.println(list);

    for (int i = 0; i < list.size() - 1; i++) {
      int maxIndex = i;
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(j) >= list.get(maxIndex) && list.get(j) > list.get(i)) {
          maxIndex = j;
        }
      }
      if (maxIndex > i) {
        int temp = list.get(i);
        list.set(i, list.get(maxIndex));
        list.set(maxIndex, temp);
        break;
      }
    }

    return convertToInt(list);
  }

  public void splitNumber(int num, List<Integer> list) {
    if (num < 10) {
      list.add(num);
    } else {
      list.add(num % 10);
      splitNumber(num / 10, list);
    }
  }

  public int convertToInt(List<Integer> list) {
    int result = -1;
    for (Integer value: list) {
      if (result == -1) {
        result = value;
      } else {
        result = result * 10 + value;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    MaximumSwap obj = new MaximumSwap();
    System.out.println(obj.maximumSwap(2736));
    System.out.println(obj.maximumSwap(9937));
    System.out.println(obj.maximumSwap(1993));
    System.out.println(obj.maximumSwap(98368));
  }
}