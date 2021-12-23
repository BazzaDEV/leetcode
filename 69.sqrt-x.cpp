/*
 * @lc app=leetcode id=69 lang=cpp
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
public:
    int mySqrt(int x) {

        if (x < 2) return x;

        int left = 0, right = x, mid = left + (right-left)/2;

        while (left <= right) {
            mid = left + (right-left)/2;
            
            if (mid > x/mid) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return right;
        
    }
};
// @lc code=end

