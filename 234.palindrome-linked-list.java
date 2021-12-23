/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);

        while (rev != null) {
            if (head.val != rev.val) return false;
            head = head.next;
            rev = rev.next;
        }

        return true;
        
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

