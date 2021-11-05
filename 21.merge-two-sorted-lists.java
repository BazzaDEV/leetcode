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
        ListNode head = dummy;

        // We are given the heads of two lists, l1 and l2.
        // To build our merged sorted list, we need to compare the heads of the lists
        // and make a decision: which node do we add to the merged list?
        
        // We need to add the smallest node to the merged list, remove that node from its
        // original list, then repeat the process until both lists are empty.

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                head.next = l2;
                break;

            } else if (l2 == null) {
                head.next = l1;
                break;

            } else if (l1.val < l2.val) {
                ListNode temp = l1.next;
                l1.next = null;
                head.next = l1;
                l1 = temp;

            } else {
                ListNode temp = l2.next;
                l2.next = null;
                head.next = l2;
                l2 = temp;

            }

            head = head.next;

            // print(dummy);

        }

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

