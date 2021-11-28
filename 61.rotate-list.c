/*
 * @lc app=leetcode id=61 lang=c
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

int length(struct ListNode *head)
{
    int count = 0;
    while (head)
    {
        count++;
        head = head->next;
    }
    return count;
}

struct ListNode *rotateRight(struct ListNode *head, int k)
{

    if (k < 1 || !head || !head->next) return head;

    struct ListNode dummyVal = {0, head},
                    *dummy = &dummyVal, *a = dummy, *b = dummy;
    
    int len = length(head);
    
    k %= len;

    if (k == 0) return head;
    
    for (int i = 0; i < k; i++) b = b->next;

    while (b->next)
    {
        a = a->next;
        b = b->next;
    }

    dummy->next = a->next;
    a->next = NULL;
    b->next = head;

    return dummy->next;
}
// @lc code=end
