/*
 * @lc app=leetcode id=53 lang=c
 *
 * [53] Maximum Subarray
 */

// @lc code=start


int maxSubArray(int* nums, int numsSize) {

    int best = INT_MIN, sum = 0;

    for (int i = 0; i < numsSize; i++) {
        if (sum + nums[i] > nums[i]) sum += nums[i];
        else sum = nums[i];

        best = max(sum, best);
    }

    return best;

}

int max(int a, int b) {
    return (a > b) ? a : b;
}
// @lc code=end

