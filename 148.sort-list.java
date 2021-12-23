/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {

        return mergeSort(head);
        
    }

    public ListNode mergeSort(ListNode head) {

        // print("head", head);

        if (head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head, prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // print("left", head);
        // print("right", slow);

        return mergeSort(
            mergeSort(head),
            mergeSort(slow)
        );

    }

    public ListNode mergeSort(ListNode h1, ListNode h2) {

        ListNode dummy = new ListNode(0, null), head = dummy;
        while (h1 != null && h2 != null) {
            head.next = (h1.val < h2.val) ? h1 : h2;
            head = head.next;

            if (h1.val < h2.val) h1 = h1.next;
            else h2 = h2.next;
        }

        head.next = (h1 != null) ? h1 : h2;

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

