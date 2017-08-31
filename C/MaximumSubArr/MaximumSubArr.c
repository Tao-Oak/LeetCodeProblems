//
// 53. Maximum Subarray
//

/*
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

int maxSubArray(int* nums, int numsSize) {
    int i, sum = nums[0], max = nums[0];
    for (i = 1; i < numsSize; i++) {
        sum = sum > 0? sum + nums[i]: nums[i];
        if (sum > max) max = sum;
    }

    return max;
}