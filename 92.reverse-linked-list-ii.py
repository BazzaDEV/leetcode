#
# @lc app=leetcode id=92 lang=python3
#
# [92] Reverse Linked List II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        a = dummy
        b = dummy
        aNext = None
        bNext = None

        for i in range(0, left-1):
            a = a.next
        
        aNext = a.next
        a.next = None

        b = aNext

        for i in range(0, right-left):
            b = b.next
        
        bNext = b.next
        b.next = None

        a.next = self.reverse(aNext)
        aNext.next = bNext

        return dummy.next
    
    def reverse(self, head: Optional[ListNode]):
        newHead = None
        toAdd = head

        while toAdd:
            next = toAdd.next
            toAdd.next = newHead
            newHead = toAdd
            toAdd = next
        
        return newHead

        
# @lc code=end

