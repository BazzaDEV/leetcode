/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, null);
        ListNode toAdd = head;

        while (toAdd != null) {
            ListNode curr = dummy, toAddNext = toAdd.next;
            toAdd.next = null;
            while (curr != null) {
                if (curr.next == null || toAdd.val <= curr.next.val) {

                    ListNode next = curr.next;
                    curr.next = toAdd;
                    toAdd.next = next;

                    break;
                }

                curr = curr.next;
            }
            toAdd = toAddNext;
        }

        return dummy.next;
        
    }

    private void print(String name, ListNode head) {
        StringBuilder strB = new StringBuilder(name + ": ");
        if (head == null) {
            strB.append("null");
            System.out.println(strB.toString().trim());
            return;
        }

        while (head != null) {
            strB.append(head.val).append(",");
            head = head.next;
        }

        String s = strB.toString().trim();
        System.out.println(s.substring(0, s.length()-1));
    }
}
// @lc code=end

