/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {

        int currSum = 0;
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (currSum + nums[i] < nums[i]) {
                // Start a new subarray with this number
                currSum = nums[i];

            } else {
                // Add this number to my subarray
                currSum += nums[i];

            }

            best = Math.max(best, currSum);

        }

        return best;
        
    }
}
// @lc code=end

