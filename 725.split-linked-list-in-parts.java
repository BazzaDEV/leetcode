/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] parts = new ListNode[k];
        int index = 0;

        int len = Math.max(length(head), k);
        int extra = len % k;

        int[] lens = new int[k];
        int partLen = len/k;
        for (int i = 0; i < k; i++) {
            lens[i] = partLen;
            if (extra > 0) {
                lens[i]++;
                extra--;
            }
        }

        ListNode a = head;

        while (a != null) {
            parts[index] = a;

            int n = lens[index];
            for (int i = 1; i < n; i++) a = a.next;

            ListNode temp = a.next;
            a.next = null;
            a = temp;

            index++;
        }

        return parts;
        
        
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

