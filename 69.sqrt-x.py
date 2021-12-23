#
# @lc app=leetcode id=69 lang=python3
#
# [69] Sqrt(x)
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x

        left = 0
        right = x

        while left <= right:
            mid = left + (right-left)//2
            if (mid > x//mid):
                right = mid-1
            else:
                left = mid+1
        
        return right
        
# @lc code=end

