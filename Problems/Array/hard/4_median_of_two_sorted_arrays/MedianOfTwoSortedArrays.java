//
// Created by Joshua.Cao, 2018/11/08
// 
// https://leetcode.com/problems/median-of-two-sorted-arrays/
//
import java.util.Arrays;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity 
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 *   nums1 = [1, 3]
 *   nums2 = [2]
 *   The median is 2.0
 * 
 * Example 2:
 *   nums1 = [1, 2]
 *   nums2 = [3, 4]
 *   The median is (2 + 3)/2 = 2.5
*/
public class MedianOfTwoSortedArrays {
  // Accepted, beats 100.00%
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    int[] buffer = new int[len1 + len2];
    int index = 0, idx1 = 0, idx2 = 0;
    while(idx1 < len1 || idx2 < len2) {
      if (idx2 >= len2) {
        buffer[index++] = nums1[idx1++];
        continue;
      }
      if (idx1 >= len1) {
        buffer[index++] = nums2[idx2++];
        continue;
      }
      if (nums1[idx1] < nums2[idx2]) {
        buffer[index++] = nums1[idx1++];
      } else {
        buffer[index++] = nums2[idx2++];
      }
    }
    // System.out.println(Arrays.toString(buffer));
    int middle = (len1 + len2) / 2;
    if ((len1 + len2) % 2 == 0) {
      return (buffer[middle] + buffer[middle - 1]) / 2.0;
    } else {
      return (double)buffer[middle];
    }
  }
  
  // Accepted, beats 24.33%
  public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    int middle1 = (len1 + len2) / 2;

    int temp1 = 0, temp2 = 0;
    int index = 0, idx1 = 0, idx2 = 0;
    while(idx1 < len1 || idx2 < len2) {
      if (index == middle1 + 1) break;
      if (idx1 < len1 && idx2 < len2) {
        if (nums1[idx1] < nums2[idx2]) {
          temp2 = temp1;
          temp1 = nums1[idx1];
          idx1++;
        } else {
          temp2 = temp1;
          temp1 = nums2[idx2];
          idx2++;
        }
      } else if (idx1 < len1) {
        temp2 = temp1;
        temp1 = nums1[idx1];
        idx1++;
      } else {
        temp2 = temp1;
        temp1 = nums2[idx2];
        idx2++;
      }
      index++;
    }
    if ((len1 + len2) % 2 == 0) {
      return (temp1 + temp2) / 2.0;
    } else {
      return temp1;
    }
  }

  private void test(int[] nums1, int[] nums2) {
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static void main(String[] args) {
    MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
    obj.test(new int[]{1, 3}, new int[]{2});
    obj.test(new int[]{1, 2}, new int[]{3, 4});
  }
}