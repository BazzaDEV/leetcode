/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {

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



    int size;
    int capacity;

    Node head;
    Node tail;

    public MyCircularDeque(int k) {
        this.capacity = k;
        size = 0;

        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if ( isFull() ) return false;

        Node node = new Node(value);

        Node next = head.next;

        head.next = node;
        node.next = next;

        next.prev = node;
        node.prev = tail.prev;
        
        tail.prev.next = node;

        size++;

        return true;
    }
    
    public boolean insertLast(int value) {
        if ( isFull() ) return false;

        Node node = new Node(value);

        Node prev = tail.prev;

        tail.prev = node;
        node.prev = prev;

        prev.next = node;
        node.next = head.next;

        head.next.prev = node;

        size++;

        return true;
    }
    
    public boolean deleteFront() {
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
    
    public boolean deleteLast() {
        if ( isEmpty() ) return false;

        if (size == 1) {
            head.next = tail;
            tail.prev = head;

        } else {
            tail.prev = tail.prev.prev;
            tail.prev.next = head.next;
            head.next.prev = tail.prev;

        }

        size--;

        return true;
    }
    
    public int getFront() {
        return head.next.val;
    }
    
    public int getRear() {
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
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

