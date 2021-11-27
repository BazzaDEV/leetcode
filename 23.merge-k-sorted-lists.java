/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length-1);
        

    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end - start == 0) {
            return lists[start];

        } else if (end - start == 1) {
            return merge2Lists(lists[start], lists[end]);

        } else {
            int mid = start + (end-start)/2;
            return merge2Lists(
                mergeKLists(lists, start, mid),
                mergeKLists(lists, mid+1, end)
            );
        }
    }

    private ListNode merge2Lists(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0), curr = dummy;

        while (h1 != null && h2 != null) {
            curr.next = (h1.val < h2.val) ? h1 : h2;
            curr = curr.next;

            if (h1.val < h2.val) h1 = h1.next;
            else h2 = h2.next;
        }

        if (h1 != null) curr.next = h1;
        else if (h2 != null) curr.next = h2;

        return dummy.next;
    }

    private void print(ListNode head) {
        StringBuilder strB = new StringBuilder();

        if (head == null) {
            System.out.println("(empty)");
            return;
        }

        while (head != null) {
            strB.append(head.val).append(" -> ");
            head = head.next;
        }

        strB.setLength(strB.length() - " -> ".length());

        System.out.println(strB.toString().trim());
    }
}
// @lc code=end

