#
# @lc app=leetcode id=109 lang=python3
#
# [109] Convert Sorted List to Binary Search Tree
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        # return self.sortedListToBST_Recursive_LinkedList(head)
        return self.sortedListToBST_Recursive_ConvertToArray(head)
    
    #####################################################################################################

    def sortedListToBST_Recursive_LinkedList(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        if not head:
            return None

        if not head.next:
            return TreeNode(head.val, None, None)

        dummy = ListNode(0, head)
        prev = dummy
        slow = head
        fast = head

        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next

        prev.next = None

        slowNext = slow.next
        slow.next = None

        root = TreeNode(slow.val)

        root.left = self.sortedListToBST_Recursive_LinkedList(dummy.next)
        root.right = self.sortedListToBST_Recursive_LinkedList(slowNext)

        return root

    #####################################################################################################

    def listToVals(self, head: Optional[ListNode]):
        global vals
        vals = []
        while head:
            vals.append(head.val)
            head = head.next

    def sortedListToBST_Recursive_ConvertToArray(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        self.listToVals(head)

        left = 0
        right = len(vals)-1
        
        return self.sortedArrayToBST(left, right)
    
    def sortedArrayToBST(self, left: int, right: int) -> Optional[TreeNode]:

        if left > right:
            return None
        if left == right:
            return TreeNode(vals[left], None, None)

        mid = left + (right-left)//2

        root = TreeNode(vals[mid])

        root.left = self.sortedArrayToBST(left, mid-1)
        root.right = self.sortedArrayToBST(mid+1, right)

        return root
# @lc code=end
