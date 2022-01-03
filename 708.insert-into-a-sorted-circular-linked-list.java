/*
 * @lc app=leetcode id=708 lang=java
 *
 * [708] Insert into a Sorted Circular Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {

        Node node = new Node(insertVal);

        if (head == null) {
            head = node;
            head.next = node;

        } else {
            Node curr = head;
            
            while (curr.next != head) {
                if (curr.val <= insertVal && insertVal <= curr.next.val) break;
                else if (curr.val > curr.next.val && (insertVal <= curr.next.val || insertVal >= curr.val)) break;
                curr = curr.next;
            }

            Node next = curr.next;
            curr.next = node;
            node.next = next;

        }

        return head;
        
    }
}
// @lc code=end

