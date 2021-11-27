/*
 * @lc app=leetcode id=66 lang=c
 *
 * [66] Plus One
 */

// @lc code=start


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){

    int i = digitsSize - 1;
    while (i >= 0) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        } else {
            digits[i] = 0;
            i--;
        }
    }

    *returnSize = digitsSize + 1;
    
    int* newDigits = (int*) calloc(*returnSize, sizeof(int)); // Dynamic array initialization using calloc

    // int* newDigits = (int*) malloc((*returnSize) * sizeof(int)); // Dynamic array initialization using malloc

    // int* newDigits = new int[*returnSize]; // C++ dynamic array initialization

    i = digitsSize;
    while (i >= 0) {
        newDigits[i--] = 0;
    }

    newDigits[0] = 1;

    return newDigits;
    



}
// @lc code=end

