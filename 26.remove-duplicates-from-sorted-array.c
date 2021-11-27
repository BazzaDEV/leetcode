/*
 * @lc app=leetcode id=26 lang=c
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start


int removeDuplicates(int* nums, int numsSize){

    if (numsSize < 1) return 0;

    int read = 0, write = 0;

    while (read < numsSize) {
        if (nums[read] != nums[write]) {
            nums[++write] = nums[read];
        }

        read++;
    }

    return write + 1;



}
// @lc code=end

