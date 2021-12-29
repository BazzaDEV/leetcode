/*
 * @lc app=leetcode id=369 lang=java
 *
 * [369] Plus One Linked List
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
    public ListNode plusOne(ListNode head) {
        
        ListNode dummy = new ListNode( 0, reverse(head) );
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val < 9) {
                head.next.val += 1;
                return reverse(dummy.next);
                
            } else {
                head.next.val = 0;
                head = head.next;
            }
        }
        
        head.next = new ListNode(1);
        
        return reverse(dummy.next);
        
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

