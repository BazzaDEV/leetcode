/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int len = Integer.MAX_VALUE;
        
        for (String s : strs) {
            len = Math.min(s.length(), len);
        }
        
        boolean flag = false;
        int i = 0;
        while (i < len) {
            
            char c = strs[0].charAt(i);
            
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            
            if (flag) break;
            
            i++;
            
        }
        
        return strs[0].substring(0, i);

    }
}
// @lc code=end

