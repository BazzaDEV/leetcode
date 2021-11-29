/*
 * @lc app=leetcode id=82 lang=c
 *
 * [82] Remove Duplicates from Sorted List II
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

    struct ListNode dummyVal = {-101, head},
                    *dummy = &dummyVal,
                    *read = head,
                    *toSkip = dummy,
                    *write = dummy;

    while (read)
    {
        if (read->next && read->val == read->next->val)
            toSkip = read;
        else if (read->val != toSkip->val)
        {
            write->next = read;
            write = write->next;
            toSkip = write;
        }

        read = read->next;
    }

    write->next = NULL;
    
    return dummy->next;
}
// @lc code=end
