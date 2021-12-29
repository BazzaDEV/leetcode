/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */

// @lc code=start
class MyCircularQueue {
    
    class Node {
        int val;
        
        Node prev;
        Node next;
        
        public Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    
    
    int size;      // Current size
    int capacity;  // Max size
    
    Node head;     // Dummy head
    Node tail;     // Dummy tail

    public MyCircularQueue(int k) {
        this.capacity = k;
        size = 0;
        
        head = new Node(-1);
        tail = new Node(-1);
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public boolean enQueue(int value) {
        
        if ( isFull() ) return false;
        
        Node node = new Node(value);
        
        Node prev = tail.prev;
        
        prev.next = node;
        node.next = head.next;
        
        head.next.prev = node;
        node.prev = prev;
        
        tail.prev = node;
        
        size++;
        
        return true;
        
    }
    
    public boolean deQueue() {
        
        if ( isEmpty() ) return false;
        
        if (size == 1) {
            head.next = tail;
            tail.prev = head;
            
        } else {
            head.next = head.next.next;
            head.next.prev = tail.prev;
            tail.prev.next = head.next;

        }
        
        size--;
        
        return true;
        
    }
    
    public int Front() {
        return head.next.val;
    }
    
    public int Rear() {
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}



/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

