#
# @lc app=leetcode id=61 lang=python3
#
# [61] Rotate List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not (head and head.next and k > 0):
            return head
        
        dummy = ListNode(0, head)
        a = dummy
        b = dummy

        k %= self.length(head)
        if k == 0:
            return head
        
        for i in range(k):
            b = b.next

        while b.next:
            a = a.next
            b = b.next

        dummy.next = a.next
        a.next = None
        b.next = head

        return dummy.next
        
    
    def length(self, head: Optional[ListNode]) -> int:
        count = 0
        
        while head:
            count += 1
            head = head.next
        
        return count

        
# @lc code=end

