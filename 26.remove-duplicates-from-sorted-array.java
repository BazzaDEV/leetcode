/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        int read = 0;
        int write = 1;

        while (read < n-1) {
            if (nums[read] != nums[read+1]) nums[write++] = nums[read+1];

            read++;
        }

        return write;
        
    }
}
// @lc code=end

