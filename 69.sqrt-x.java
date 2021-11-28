/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {

/*

    sqrt 2 = 1....
    sqrt 3 = 1.7...
    sqrt 4 = 2
    sqrt 9 = 3
    sqrt 16 = 4
    sqrt 81 = 9


 */


    public int mySqrt(int x) {

        if (x < 2) return x;

        int left = 2, right = x/2, mid = left + (right-left)/2;
        while (left <= right) {
            mid = left + (right-left)/2;

            if (mid > x/mid) { // same as mid * mid = x
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
        
    }

}
// @lc code=end

