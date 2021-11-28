/*
 * @lc app=leetcode id=83 lang=c
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode *deleteDuplicates(struct ListNode *head)
{

    if (!head || !head->next) return head;

    struct ListNode *read = head, *write = head;

    while (read) {
        if (read->val != write->val) {
            write->next = read;
            write = write->next;
        }

        read = read->next;
    }

    write->next = NULL;
    return head;
}
// @lc code=end
