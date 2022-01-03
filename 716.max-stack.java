/*
 * @lc app=leetcode id=716 lang=java
 *
 * [716] Max Stack
 */

// @lc code=start
class MaxStack {

    class Node {
        int val;
        Node prev, next;

        public Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }



    Node head, tail, max;

    public MaxStack() {
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;

        max = null;
    }
    
    public void push(int x) {
        Node node = new Node(x);
        Node next = head.next;

        head.next = node;
        node.next = next;

        next.prev = node;
        node.prev = head;

        if (max == null || node.val >= max.val) max = node;
    }
    
    public int pop() {
        Node temp = head.next;

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        if (temp == max) findMax();

        return temp.val;
    }
    
    public int top() {
        return head.next.val;
    }
    
    public int peekMax() {
        return max.val;
    }
    
    public int popMax() {
        Node temp = max;

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        findMax();

        return temp.val;
    }

    private void findMax() {
        max = null;
        
        Node curr = head.next;
        while (curr != tail) {
            if (max == null || curr.val > max.val) max = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
// @lc code=end

