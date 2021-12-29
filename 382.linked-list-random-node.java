/*
 * @lc app=leetcode id=382 lang=java
 *
 * [382] Linked List Random Node
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
    
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
        
    }
    
    public int getRandom() {
        
        int res = head.val;
        ListNode node = head.next;
        
        int i = 1;
        while (node != null) {
            if ( (int)(Math.random() * (i+1)) < 1 ) 
                res = node.val;
            
            i++;
            node = node.next;
        }
        
        return res;
        
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

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

