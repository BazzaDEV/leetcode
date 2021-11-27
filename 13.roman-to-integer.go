/*
 * @lc app=leetcode id=13 lang=golang
 *
 * [13] Roman to Integer
 */

// @lc code=start
func romanToInt(s string) int {

	m := make(map[byte]int)

	m['I'] = 1
    m['V'] = 5
    m['X'] = 10
    m['L'] = 50
    m['C'] = 100
    m['D'] = 500
    m['M'] = 1000

	aSum := 0
	sLen := len(s)

	for i := 0; i < sLen-1; i++ {

		curr := m[ s[i] ]
		next := m[ s[i+1] ]

		if (curr < next) {
			aSum -= curr
		} else {
			aSum += curr
		}

	}

	aSum += m[ s[sLen-1] ]

	return aSum
    
}
// @lc code=end

