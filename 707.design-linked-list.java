/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */

// @lc code=start
class MyLinkedList {

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




    int length;
    Node head;
    Node tail;

    public MyLinkedList() {
        length = 0;

        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if (index > length) { // Do not insert
            return -1;

        } else { // Get node val at index
            Node curr = head.next;
            for (int i = 0; i < index; i++) curr = curr.next;
            
            return curr.val;
        }
    }
    
    public void addAtHead(int val) {
        insertAfter(head, val);
        length++;
    }
    
    public void addAtTail(int val) {
        insertAfter(tail.prev, val);
        length++;
    }
    
    public void addAtIndex(int index, int val) {

        if (index > length) { // Do not insert
            return;

        } else if (index == length) { // Insert at tail
            addAtTail(val);

        } else { // Add before index
            Node curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
            
            insertAfter(curr, val);
            length++;

        }

    }
    
    public void deleteAtIndex(int index) {
        if (index < length) { // Remove node at index
            Node curr = head.next;
            for (int i = 0; i < index; i++) curr = curr.next;
            
            remove(curr);
            length--;

        } else { // Index out of bounds - do not remove
            return;

        }

    }

    private void insertAfter(Node head, int val) {
        Node node = new Node(val);
        Node next = head.next;

        head.next = node;
        node.next = next;

        next.prev = node;
        node.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

