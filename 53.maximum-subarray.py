#
# @lc app=leetcode id=53 lang=python3
#
# [53] Maximum Subarray
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        localMax = nums[0]
        globalMax = nums[0]

        i = 1
        while i < len(nums):
            num = nums[i]
            localMax = num if num > localMax + num else localMax + num
            globalMax = localMax if localMax > globalMax else globalMax
            i += 1
        
        return globalMax

        
# @lc code=end

