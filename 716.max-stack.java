/*
 * @lc app=leetcode id=716 lang=java
 *
 * [716] Max Stack
 */

// @lc code=start
class MaxStack {

    class Node {
        int val, clock;
        Node prev, next;

        public Node(int val, int clock) {
            this.val = val;
            this.clock = clock;
            prev = null;
            next = null;
        }
    }

    int clock;
    PriorityQueue<Node> q;
    Node head, tail;

    public MaxStack() {

        clock = 0;

        q = new PriorityQueue<>((a, b) -> {
            if (a.val > b.val) return -1;
            else if (a.val < b.val) return 1;
            else if (a.clock > b.clock) return -1;
            else if (a.clock < b.clock) return 1;
            else return 0;
        });

        head = new Node(-1, clock++);
        tail = new Node(-1, clock++);

        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        Node node = new Node(x, clock++);
        Node next = head.next;

        head.next = node;
        node.next = next;

        next.prev = node;
        node.prev = head;

        q.offer(node);
    }
    
    public int pop() {
        Node temp = head.next;

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        q.remove(temp);

        return temp.val;
    }
    
    public int top() {
        return head.next.val;
    }
    
    public int peekMax() {
        return q.peek().val;
    }
    
    public int popMax() {
        Node temp = q.poll();

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return temp.val;
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

