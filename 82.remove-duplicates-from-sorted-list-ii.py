#
# @lc app=leetcode id=82 lang=python3
#
# [82] Remove Duplicates from Sorted List II
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

        dummy = ListNode(-101, head)
        read = head
        toSkip = dummy
        write = dummy

        while read:
            if read.next and read.val == read.next.val:
                toSkip = read
            elif read.val != toSkip.val:
                write.next = read
                write = write.next
                toSkip = write
            
            read = read.next
        
        write.next = None

        return dummy.next
            

        
# @lc code=end

