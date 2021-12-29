/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public Node flatten(Node head) {
        
        if (head == null) return head;
        
        Node dummy = new Node(0, null, head, null);
        
        helper(dummy, head);
        
        dummy.next.prev = null;
        
        return head;
        
    }
    
    // Node last = null;
    
    private Node helper(Node prev, Node curr) {
        
        if (curr == null) return prev;
        
        prev.next = curr;
        curr.prev = prev;
        
        Node next = curr.next;
        
        Node tail = helper(curr, curr.child);
        
        curr.child = null;
        
        return helper(tail, next);
        
        
    }
}
// @lc code=end

