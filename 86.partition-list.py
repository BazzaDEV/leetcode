#
# @lc app=leetcode id=86 lang=python3
#
# [86] Partition List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        leftHead = ListNode(0, None)
        left = leftHead
        rightHead = ListNode(0, None)
        right = rightHead

        while head:
            if head.val < x:
                left.next = head
                left = left.next
            else:
                right.next = head
                right = right.next
            
            head = head.next
        
        right.next = None
        left.next = rightHead.next

        return leftHead.next

        
# @lc code=end

