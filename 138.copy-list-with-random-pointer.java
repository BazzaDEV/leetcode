/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);

        Node copy = new Node(head.val);
        map.put(head, copy);

        copy.random = (map.containsKey(head.random)) ? map.get(head.random) : copyRandomList(head.random);
        copy.next = (map.containsKey(head.next)) ? map.get(head.next) : copyRandomList(head.next);

        return copy;

    }
}
// @lc code=end

