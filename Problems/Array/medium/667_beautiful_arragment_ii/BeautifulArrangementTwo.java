import java.util.Arrays;

//
// Created by Joshua.cao, 2018/10/23
//
// https://leetcode.com/problems/beautiful-arrangement-ii/
//
public class BeautifulArrangementTwo {
  // Accepted, beats 33.95%
  public int[] constructArray(int n, int k) {
    int[] result = new int[n];

    result[0] = 1;
    int temp = k;
    for (int i = 1; i < n; i++) {
      if (temp == 0) {
        temp--;
        result[i] = k + 2;
      } else if (temp < 0) {
        result[i] = result[i - 1] + 1;
      } else {
        if ((k - temp) % 2 == 0) {
          result[i] = result[i - 1] + temp--;
        } else {
          result[i] = result[i - 1] - temp--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    BeautifulArrangementTwo obj = new BeautifulArrangementTwo();
    System.out.println(Arrays.toString(obj.constructArray(3, 1)));
    System.out.println(Arrays.toString(obj.constructArray(3, 2)));
    System.out.println(Arrays.toString(obj.constructArray(5, 2)));
  }
}