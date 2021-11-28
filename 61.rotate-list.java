/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) return head;

        int len = length(head);
        k %= len;

        if (k == 0) return head;

        ListNode dummy = new ListNode(0, head),
        a = dummy, b = dummy;

        for (int i = 0; i < k; i++) b = b.next;

        while (b.next != null) {
            a = a.next;
            b = b.next;
        }

        dummy.next = a.next;
        a.next = null;

        b.next = head;

        return dummy.next;

    }

    private int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
// @lc code=end

