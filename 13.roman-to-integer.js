/*
 * @lc app=leetcode id=13 lang=javascript
 *
 * [13] Roman to Integer
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {

    const map = new Map();

    map.set('I', 1);
    map.set('V', 5);
    map.set('X', 10);
    map.set('L', 50);
    map.set('C', 100);
    map.set('D', 500);
    map.set('M', 1000);

    const sLen = s.length;
    sum = 0;

    for (let i = 0; i < sLen-1; i++) {
        const curr = map.get( s[i] );
        const next = map.get( s[i+1] );

        sum = (curr < next) ? sum - curr : sum + curr;
        
    }

    sum += map.get( s[sLen-1] );

    return sum;


    
};
// @lc code=end

