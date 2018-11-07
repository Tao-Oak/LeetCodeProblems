//
// Created by Joshua.Cao, 2018/11/01
// 
// https://leetcode.com/problems/advantage-shuffle/
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Given two arrays A and B of equal size, the advantage of A with respect to B 
 * is the number of indices i for which A[i] > B[i].
 * 
 * Return any permutation of A that maximizes its advantage with respect to B.
 * 
 * Example 1:
 *   Input: A = [2,7,11,15], B = [1,10,4,11]
 *   Output: [2,11,7,15]
 * 
 * Example 2:
 *   Input: A = [12,24,8,32], B = [13,25,32,11]
 *   Output: [24,32,8,12]
 *
 * Note:
 *   1. 1 <= A.length = B.length <= 10000
 *   2. 0 <= A[i] <= 10^9
 *   3. 0 <= B[i] <= 10^9
 */
public class AdvantageShuffle {
  // Accepted, beats 98.35%
  public int[] advantageCount(int[] A, int[] B) {
    int n = A.length, INDEX_SHIFTS = 14;
    long INDEX_MASKS = (1L << INDEX_SHIFTS) - 1L;
    long[] buffer = new long[n];
    for (int i = 0; i < n; i++) {
      buffer[i] = ((long)B[i] << INDEX_SHIFTS) | (long)i;
    }
    Arrays.sort(A);
    Arrays.sort(buffer);

    int left = 0, right = n - 1;
    for (int v: A) {
      int temp = (int)(buffer[left] >>> INDEX_SHIFTS);
      if (v > temp) {
        B[(int)(buffer[left++] & INDEX_MASKS)] = v;
      } else {
        B[(int)(buffer[right--] & INDEX_MASKS)] = v;
      }
    }
    return B;
  }

  // Accepted, beats 59.38%
  public int[] advantageCount_1(int[] A, int[] B) {
    int n = A.length;
    int[] result = new int[n];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<Integer> list = map.getOrDefault(B[i], new ArrayList<>());
      list.add(i);
      map.put(B[i], list);
    }
    Arrays.sort(A);
    Arrays.sort(B);

    int left = 0, right = n - 1;
    for (int value: A) {
      int target = value > B[left] ? B[left++] : B[right--];
      
      List<Integer> list = map.get(target);
      int index = list.remove(list.size() - 1);
      result[index] = value;
      if (list.size() <= 0) map.remove(target);
    }
    return result;
  }

  // Accepted, beats 58.35%
  public int[] advantageCount_3(int[] A, int[] B) {
    int n = A.length;
    int[] result = new int[n];
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }
    
    for (int i = 0; i < n; i++) {
      Map.Entry<Integer,Integer> entry = map.higherEntry(B[i]);
      if (entry == null) {
        entry = map.firstEntry();
      }
      result[i] = entry.getKey();
      int value = entry.getValue();
      if (value > 1) {
        map.replace(result[i], value - 1);
      } else {
        map.remove(result[i]);
      }
    }

    return result;
  }

  public int[] advantageCount_4(int[] A, int[] B) {
    int n = A.length;
    Arrays.sort(A);
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      boolean found = false;
      for (int j = 0; j < n; j++) {
        if (A[j] > B[i]) {
          result[i] = A[j];
          A[j] = -1;
          found = true;
          break;
        }
      }
      if (!found) {
        for (int j = 0; j < n; j++) {
          if (A[j] != -1) {
            result[i] = A[j];
            break;
          }
        }
      }
    }
    return result;
  }

  private void test(int[] A, int[] B) {
    int[] result = advantageCount(A, B);
    System.out.println(Arrays.toString(result));
  }

  public static void main(String[] args) {
    AdvantageShuffle obj = new AdvantageShuffle();
    int[] A_1 = {2,7,11,15}, B_1 = {1,10,4,11};
    obj.test(A_1, B_1);

    int[] A_2 = {12,24,8,32}, B_2 = {13,25,32,11};
    obj.test(A_2, B_2);
  }
}