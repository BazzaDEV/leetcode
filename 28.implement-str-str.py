#
# @lc app=leetcode id=28 lang=python3
#
# [28] Implement strStr()
#

# @lc code=start
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        hayLen = len(haystack)
        needLen = len(needle)

        if needLen < 1:
            return 0
        if needLen > hayLen:
            return -1

        i = 0
        j = needLen-1
        while j < hayLen:
            
            # Method 1:
            # Compare haystack and needle sliding window, character by character
            # NOTE: Time limit exceeds on test case 79/80

            # k = 0
            # while k < needLen:
            #     if (haystack[i+k] != needle[k]):
            #         break
            #     k += 1
            
            # if (k == needLen):
            #     return i

            # Method 2:
            # Two preliminary checks with first and last characters, then substring check

            if (haystack[i] == needle[0] and haystack[j] == needle[-1] and haystack[i:j+1] == needle):
                return i
            
            i += 1
            j += 1
        
        return -1
        
# @lc code=end

