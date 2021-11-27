/*
 * @lc app=leetcode id=13 lang=c
 *
 * [13] Roman to Integer
 */

// @lc code=start


int romanToInt(char * s){

    int len = strlen(s);

    int toInt['Z'] = {};

    toInt['I'] = 1;
    toInt['V'] = 5;
    toInt['X'] = 10;
    toInt['L'] = 50;
    toInt['C'] = 100;
    toInt['D'] = 500;
    toInt['M'] = 1000;

    int sum = 0;

    for (int i = 0; i < len-1; i++) {
        int curr = toInt[ s[i] ], next = toInt[ s[i+1] ];
        sum = (curr < next) ? (sum - curr) : (sum + curr);
    }

    sum += toInt[ s[len-1] ];

    return sum;
}
// @lc code=end

