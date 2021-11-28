/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        ListNode read = head, write = head;

        while (read != null) {
            if (write.val != read.val) {
                write.next = read;
                write = write.next;
            }

            read = read.next;
        }

        write.next = null;

        return head;

    }
}
// @lc code=end

