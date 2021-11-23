/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {

        int[] digitsP1 = new int[digits.length + 1];
        int carry = 1;

        for (int i=digits.length-1; i >= 0; i--) {
            int d = digits[i];

            int sum = d + carry;

            digitsP1[i+1] += sum % 10;

            carry = (sum > 9) ? 1 : 0;
        }

        if (carry > 0) digitsP1[0] += carry;

        return (digitsP1[0] > 0) ? digitsP1 : Arrays.copyOfRange(digitsP1, 1, digitsP1.length);
        
    }
}
// @lc code=end

