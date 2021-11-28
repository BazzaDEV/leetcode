#
# @lc app=leetcode id=25 lang=python3
#
# [25] Reverse Nodes in k-Group
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:

        dummy = ListNode(0, head)
        a = dummy
        b = dummy
        aNext = None
        bNext = None

        left = 1
        right = k

        while a.next:
            b = a.next

            for i in range(right-left):
                if b.next:
                    b = b.next
                else:
                    return dummy.next

            aNext = a.next
            a.next = None

            bNext = b.next
            b.next = None

            a.next = self.reverse(aNext)
            aNext.next = bNext

            a = aNext
        
        return dummy.next
        
    
    def reverse(self, head: Optional[ListNode]) -> Optional[ListNode]:
        newHead = None
        toAdd = head

        while toAdd:
            next = toAdd.next
            toAdd.next = newHead
            newHead = toAdd
            toAdd = next
        
        return newHead
        
# @lc code=end

