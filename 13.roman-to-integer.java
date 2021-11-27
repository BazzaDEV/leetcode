/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int len = s.length()-1;

        for (int i = 0; i < len; i++) {
            int curr = map.get(s.charAt(i)), next = map.get(s.charAt(i+1));
            if (curr < next) sum -= curr;
            else sum += curr;
        }

        sum += map.get( s.charAt(len) );

        return sum;
        
    }
}
// @lc code=end

