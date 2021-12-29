/*
 * @lc app=leetcode id=426 lang=java
 *
 * [426] Convert Binary Search Tree to Sorted Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    Node first = null;
    Node last = null;
    
    public Node treeToDoublyList(Node root) {
        
        if (root == null) return null;
        
        visit(root);
        
        first.left = last;
        last.right = first;
        
        return first;
        
    }
    
    private void visit(Node root) {
        if (root != null) {
            
            visit(root.left);
            
            if (last != null) {
                
                last.right = root;
                root.left = last;
                
            } else {
                
                first = root;
                
            }
            
            last = root;
            
            visit(root.right);
            
        }
    }
}
// @lc code=end

