/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m+n];
        int size = res.length;

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) 
            res[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];

        while (i < m) res[k++] = nums1[i++];
        while (j < n) res[k++] = nums2[j++];

        // System.out.println(Arrays.toString(res));

        i = 0;
        while (i < size) {
            nums1[i] = res[i];
            i++;
        }

    }
}
// @lc code=end

