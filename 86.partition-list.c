/*
 * @lc app=leetcode id=86 lang=c
 *
 * [86] Partition List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode *partition(struct ListNode *head, int x)
{
    struct ListNode leftHeadVal = {0, NULL},
                    rightHeadVal = {0, NULL},
                    *leftHead = &leftHeadVal,
                    *rightHead = &rightHeadVal,
                    *left = leftHead,
                    *right = rightHead;

    while (head)
    {
        if (head->val < x)
        {
            left->next = head;
            left = left->next;
        }
        else
        {
            right->next = head;
            right = right->next;
        }

        head = head->next;
    }

    right->next = NULL;
    left->next = rightHead->next;

    return leftHead->next;
    
}
// @lc code=end
