/*
 * @lc app=leetcode id=28 lang=c
 *
 * [28] Implement strStr()
 */

// @lc code=start


int strStr(char * haystack, char * needle){

    int hayLen = strlen(haystack), needLen = strlen(needle);

    if (needLen == 0) return 0;

    for (int i = 0, j = needLen-1; j < hayLen; i++, j++) {

        int k = 0;
        while (k < needLen) {
            if (haystack[i+k] != needle[k]) break;
            k++;
        }

        if (k == needLen) return i;

    }

    return -1;

}
// @lc code=end

