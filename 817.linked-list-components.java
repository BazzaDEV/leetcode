/*
 * @lc app=leetcode id=817 lang=java
 *
 * [817] Linked List Components
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
    public int numComponents(ListNode head, int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        int components = set.size();

        while (head.next != null) {
            if (set.contains(head.val) && set.contains(head.next.val)) components--;

            head = head.next;
        }

        return components;
        
    }
}
// @lc code=end

