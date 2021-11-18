/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=dummy
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // We will use a 'dummy' node to represent the start of our merged list.
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            curr.next = (l1.val < l2.val) ? l1 : l2;

            curr = curr.next;
            if (l1.val < l2.val) l1 = l1.next;
            else l2 = l2.next;

        }

        if (l1 == null) curr.next = l2;
        else if (l2 == null) curr.next = l1;

        return dummy.next;
        
    }

    private void print(ListNode node) {
        StringBuilder strB = new StringBuilder();
        strB.append("( ");

        while (node != null) {
            strB.append(node.val).append(" ");
            node = node.next;
        }

        strB.append(")");

        System.out.println(strB.toString().trim());
    }
}
// @lc code=end

