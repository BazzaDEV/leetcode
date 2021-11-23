/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {

        int needleLen = needle.length();
        int hayLen = haystack.length();
        
        if (needleLen == 0) return 0;
        if (needleLen > hayLen) return -1;

        char sTarget = needle.charAt(0);
        char eTarget = needle.charAt(needleLen-1);
        
        int latestStart = hayLen - needleLen + 1;

        for (int i = 0; i < latestStart; i++) {

            if (sTarget == haystack.charAt(i) && eTarget == haystack.charAt(i+needleLen-1) && haystack.substring(i, i+needleLen).equals(needle)) return i;
            
        }

        return -1;
    }
}
// @lc code=end

