/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE, head),
        read = head, toSkip = dummy, write = dummy;

        while (read != null) {
            if (read.next != null && read.val == read.next.val) {
                toSkip = read;
            }
            else if (read.val != toSkip.val) {
                write.next = read;
                write = write.next;
                toSkip = write;
            }

            read = read.next;
        }

        write.next = null;
        
        return dummy.next;




        // ListNode dummy = new ListNode(0, head), read = head, write = dummy;

        // while (read != null) {
            
        //     if (isCandidate(read)) {
        //         write.next = read;
        //         write = write.next;

        //     }

        //     read = nextCandidate(read);
            
        // }

        // write.next = null;

        // return dummy.next;

        
    }

    private boolean isCandidate(ListNode head) {
        return head.next == null || head.val != head.next.val;
    }

    private ListNode nextCandidate(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != head.val) return curr;
            curr = curr.next;
        }
        return null;
    }
}
// @lc code=end

