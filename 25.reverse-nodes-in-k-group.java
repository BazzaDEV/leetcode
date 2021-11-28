/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head),
        a = dummy, b = dummy, aNext = null, bNext = null;

        int left = 1, right = k;
        while (a.next != null) {

            b = a.next;

            for (int i = 0; i < right-left; i++) {
                if (b.next == null) return dummy.next;
                b = b.next; 
            }

            aNext = a.next;
            a.next = null;

            bNext = b.next;
            b.next = null;

            a.next = reverse(aNext);
            aNext.next = bNext;

            a = aNext;

        }

        return dummy.next;
        
        
    }

    public ListNode reverse(ListNode head) {
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

