/*
 * @lc app=leetcode id=25 lang=c
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode *reverse(struct ListNode *head)
{
    struct ListNode *newHead = NULL, *toAdd = head;

    while (toAdd)
    {
        struct ListNode *next = toAdd->next;
        toAdd->next = newHead;
        newHead = toAdd;
        toAdd = next;
    }

    return newHead;
}

struct ListNode *reverseKGroup(struct ListNode *head, int k)
{
    struct ListNode dummyVal = { 0, head };
    struct ListNode *dummy = &dummyVal,
                    *a = dummy, *b = dummy, *aNext = NULL, *bNext = NULL;

    int left = 1, right = k;

    while (a->next)
    {
        b = a->next;

        for (int i = 0; i < right - left; i++)
        {
            if (!b->next)
                return dummy->next;
            else
                b = b->next;
        }

        aNext = a->next;
        a->next = NULL;

        bNext = b->next;
        b->next = NULL;

        a->next = reverse(aNext);
        aNext->next = bNext;

        a = aNext;
    }

    return dummy->next;
}
// @lc code=end
