//
// Created by Joshua.Cao, 2018/10/27
//
// https://leetcode.com/problems/max-chunks-to-make-sorted/
//

public class MaximumChunksToMakeSorted {
  public int maxChunksToSorted(int[] arr) {
    if (arr.length <= 0) return 0;
    int counter = 0, distance = 0, index = 0;
    while (index < arr.length) {
      distance += arr[index] - index;
      if (distance == 0) counter++;
      index++;
    }
    return counter;
  }

  // Accepted, beats 10.05%
  public int maxChunksToSorted_2(int[] arr) {
    if (arr.length <= 0) return 0;
    int counter = 0, maxValue = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > maxValue) maxValue = arr[i];
      if (i >= maxValue) {
        counter++;
        maxValue = -1;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    MaximumChunksToMakeSorted obj = new MaximumChunksToMakeSorted();
    int[] input_1 = {4,3,2,1,0};
    System.out.println(obj.maxChunksToSorted(input_1));
    int[] input_2 = {1,0,2,3,4};
    System.out.println(obj.maxChunksToSorted(input_2));
  }
}