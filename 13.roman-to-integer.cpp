/*
 * @lc app=leetcode id=13 lang=cpp
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution
{
public:
    int romanToInt(string s)
    {

        int len = s.length();

        int toInt['Z'] = {};

        toInt['I'] = 1;
        toInt['V'] = 5;
        toInt['X'] = 10;
        toInt['L'] = 50;
        toInt['C'] = 100;
        toInt['D'] = 500;
        toInt['M'] = 1000;

        int sum = 0;

        for (int i = 0; i < len - 1; i++)
        {
            int curr = toInt[s[i]], next = toInt[s[i + 1]];
            sum = (curr < next) ? (sum - curr) : (sum + curr);
        }

        sum += toInt[s[len - 1]];

        return sum;
    }
};
// @lc code=end
