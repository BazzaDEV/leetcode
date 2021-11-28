/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head),
        a = dummy, b = dummy, aNext = null, bNext = null;

        for (int i = 0; i < left-1; i++) a = a.next;

        aNext = a.next;
        a.next = null;
        b = aNext;

        for (int i = 0; i < right-left; i++) b = b.next;

        bNext = b.next;
        b.next = null;

        a.next = reverse(aNext);
        aNext.next = bNext;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null, toAdd = head;
        while (toAdd != null) {
            ListNode next = toAdd.next;
            toAdd.next = newHead;
            newHead = toAdd;
            toAdd = next;
        }

        return newHead;
    }

    
}
// @lc code=end

