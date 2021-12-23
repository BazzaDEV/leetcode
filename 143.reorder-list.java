/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode dummy = new ListNode(0, head),
            slow = dummy.next, fast = dummy.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode rev = reverse(next);

        head = merge(head, rev);

    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0, null), curr = dummy;
        while (h1 != null && h2 != null) {
            curr.next = h1;
            h1 = h1.next;
            curr = curr.next;

            curr.next = h2;
            h2 = h2.next;
            curr = curr.next;
            curr.next = null; 
        }

        if (h1 != null) curr.next = h1;
        else curr.next = h2;

        return dummy.next;
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

