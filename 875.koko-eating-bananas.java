/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = max(piles), mid = left + (right-left)/2;

        while (left <= right) {
            mid = left + (right-left)/2;
            
            if (canFinish(piles, h, mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;

    }

    private int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            if (p > max) max = p;
        }
        return max;
    }

    private boolean canFinish(int[] piles, int h, int k) {

        int count = 0, i = 0, n = piles.length;
        while (i < n && count <= h) {

            count += piles[i] / k;
            if (piles[i] % k != 0) count++;

            i++;

        }

        return count <= h;

    }

    
}
// @lc code=end

