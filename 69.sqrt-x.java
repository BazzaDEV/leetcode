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

        if (x == 0) return x;

        int left = 1, right = x, mid = left + (right - left)/2;

        while (left < right) {

            mid = left + (right - left)/2;

            // System.out.println("left " + left + " right " + right);
            // System.out.println(mid + " " + x/mid);
            // System.out.println();

            if (mid <= x/mid && (mid+1) > x/(mid+1)) {
                return mid;

            } else if (mid > x/mid) {
                right = mid;

            } else {
                left = mid + 1;

            }
            

        }

        // System.out.println("DONE!");
        // System.out.println("left " + left + " right " + right);
        // System.out.println(mid + " " + x/mid);
        // System.out.println();

        return left;
        
    }

}
// @lc code=end

