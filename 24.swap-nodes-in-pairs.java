/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head), curr = dummy;

        while (curr.next != null && curr.next.next != null) {

            ListNode one = curr.next;
            ListNode two = curr.next.next;
            ListNode nextPair = curr.next.next.next;

            curr.next = two;
            curr = curr.next;

            curr.next = one;
            curr = curr.next;

            curr.next = nextPair;

        }

        return dummy.next;
        
    }
}
// @lc code=end

