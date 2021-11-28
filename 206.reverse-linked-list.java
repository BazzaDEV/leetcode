/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode last = null, next = head.next;
        
        while (next != null) {
            head.next = last;
            last = head;
            head = next;
            next = head.next;
        }

        head.next = last;

        return head;

        
        
    }
}
// @lc code=end

