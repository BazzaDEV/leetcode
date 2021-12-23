/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        // Get node from map
        Node node = map.get(key);

        // Move node to front of list
        remove(node);
        addFirst(node);

        // Return node value
        return node.val;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);

            map.put(key, node);
            addFirst(node);

            if (map.size() > capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

        } else {
            Node node = map.get(key);
            node.val = value;

            remove(node);
            addFirst(node);

        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addFirst(Node node) {
        Node next = head.next;

        head.next = node;
        node.next = next;

        next.prev = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

