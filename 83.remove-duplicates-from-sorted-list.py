#
# @lc app=leetcode id=83 lang=python3
#
# [83] Remove Duplicates from Sorted List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        if not (head and head.next):
            return head
        
        read = head
        write = head

        while read:
            if read.val != write.val:
                write.next = read
                write = write.next
            
            read = read.next
        
        write.next = None
        return head
        
# @lc code=end

