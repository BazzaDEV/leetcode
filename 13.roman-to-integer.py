#
# @lc app=leetcode id=13 lang=python3
#
# [13] Roman to Integer
#

# @lc code=start
class Solution:
    def romanToInt(self, s: str) -> int:
        toInt = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }

        sLen = len(s)

        sum = 0
        for i in range(sLen-1):
            curr = toInt[ s[i] ]
            next = toInt[ s[i+1] ]

            # (if_condition_FALSE, if_condition_TRUE)[condition]
            # sum = (sum + curr, sum - curr)[curr < next]

            # if_condition_TRUE if condition else if_condition_FALSE
            sum = sum - curr if curr < next else sum + curr
        
        sum += toInt[ s[sLen-1] ]

        return sum

        
# @lc code=end

