#include <stdio.h>

void moveZeroes(int* nums, int numSize);

int main(void) {
	int nums[] = {0, 1, 0, 3, 12};

	moveZeroes(nums, 5);
}

void moveZeroes(int* nums, int numsSize) {
	int holePos = 0, seekPos = 0;

	for (; seekPos < numsSize; seekPos++) {
		if (nums[seekPos] != 0) {
			nums[holePos++] = nums[seekPos];
		}
	}

	for (; holePos < numsSize; holePos++) {
		nums[holePos] = 0;
	}

	// add something
}
