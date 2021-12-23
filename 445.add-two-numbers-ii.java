/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(0, null);
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;

            dummy.next = new ListNode(sum % 10, dummy.next);

            if (sum > 9) carry = 1;
            else carry = 0;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            
    
        }

        if (carry > 0) dummy.next = new ListNode(1, dummy.next);

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

