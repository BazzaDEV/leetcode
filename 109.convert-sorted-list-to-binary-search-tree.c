/*
 * @lc app=leetcode id=109 lang=c
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

void populateVals(int *vals, int valsSize, struct ListNode *head);
int length(struct ListNode* head);
struct TreeNode* sortedArrayToBST(int left, int right, int *vals, int valsSize);

void populateVals(int *vals, int valsSize, struct ListNode *head) {

    for (int i = 0; i < valsSize; i++) {
        vals[i] = head->val;
        head = head->next;
    }
}

int length(struct ListNode* head) {
    int count = 0;
    while (head) {
        count++;
        head = head->next;
    }
    return count;
}

struct TreeNode* sortedArrayToBST(int left, int right, int *vals, int valsSize) {

    if (left > right) {
        return NULL;
    }
    
    int mid = left + (right-left)/2;

    struct TreeNode *root = (struct TreeNode *) malloc( sizeof(struct TreeNode) );
    
    root->val = vals[mid];
    root->left = NULL;
    root->right = NULL;

    if (left == right) return root;

    root->left = sortedArrayToBST(left, mid-1, vals, valsSize);
    root->right = sortedArrayToBST(mid+1, right, vals, valsSize);

    return root;

}

struct TreeNode* sortedListToBST(struct ListNode* head) {

    int valsSize = length(head);
    int *vals = (int *) calloc(valsSize, sizeof(int));

    populateVals(vals, valsSize, head);

    return sortedArrayToBST(0, valsSize-1, vals, valsSize);

}
// @lc code=end

