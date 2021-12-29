/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class LFUCache {
    
    class Bucket {
        int count;
        
        HashMap<Integer, Node> keys;
        
        Node head;
        Node tail;
        
        Bucket prev;
        Bucket next;
        
        public Bucket(int count) {
            this.count = count;
            
            keys = new HashMap<>();
            
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            
            head.next = tail;
            tail.prev = head;
            
            prev = null;
            next = null;
            
        }
        
        public void insertFirst(Node node) {
            Node next = head.next;
            
            head.next = node;
            node.next = next;
            
            next.prev = node;
            node.prev = head;
            
            keys.put(node.key, node);
            
        }
        
        public Node removeLast() {
            Node node = tail.prev;
            if (node == head) return null;
            
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            keys.remove(node.key);
            
            return node;
        }
        
        public Node remove(int key) {
            Node node = keys.get(key);
            
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            keys.remove(node.key);
            
            return node;
        }
        
        public boolean empty() {
            return keys.isEmpty();
        }
        
        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append(count).append(": ");
            
            Node curr = head.next;
            
            if (curr == tail) str.append("[ *EMPTY* ]");
            else {
                str.append("[");
                
                while (curr.next != tail) {
                    str.append("(").append(curr.key).append(", ").append(curr.value).append("), ");
                    curr = curr.next;
                }
                
                str.append("(").append(curr.key).append(", ").append(curr.value).append(")");
                str.append("]");
            }
            
            return str.toString().trim();
        }
        
    }
    
    
    
    
    
    class Node {
        int key;
        int value;
        
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            
            prev = null;
            next = null;
        }
    }
    
    
    
    
    
    int capacity;

    HashMap<Integer, Bucket> bucketMap;
    HashMap<Integer, Integer> keyCountMap;
    
    Bucket head;
    Bucket tail;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        
        bucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
        
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        
        // System.out.println("Getting key " + key + "...");
        
        if ( !keyCountMap.containsKey(key) )
            return -1;
        
        Node node = incrementKey(key);
        
        // print();
        
        return node.value;
        
    }
    
    public void put(int key, int value) {
        
        // System.out.println("Putting key " + key + "...");
        
        if (capacity < 1) return;
        
        if ( keyCountMap.containsKey(key) ) {
            // System.out.println("Key already exists! Updating its value...");
            int count = keyCountMap.get(key);
            Bucket bucket = bucketMap.get(count);
            Node node = bucket.keys.get(key);
            node.value = value;
            
            incrementKey(key);
            
        } else {
            // System.out.println("This is a new key. Adding to structure...");
            Node node = new Node(key, value);
        
            keyCountMap.put(node.key, 1);
            
            if (keyCountMap.size() > capacity) {

                Node removed = head.next.removeLast();
                keyCountMap.remove(removed.key);
                
                // System.out.println("Capacity reached. Removing LFU/LRU key " + removed.key + " before insertion...");
                
                // print();

            }

            Bucket newBucket =
                bucketMap.containsKey(1)
                ? bucketMap.get(1)
                : createBucketAfter(head);

            newBucket.insertFirst(node);
                        
        }
    
        // print();
        
    }
    
    // Helper Methods
    
    public Node incrementKey(int key) {
        int count = keyCountMap.get(key);
        Bucket bucket = bucketMap.get(count);
        
        Node node = bucket.remove(key);
        keyCountMap.remove(key);
        
        keyCountMap.put(key, count + 1);
        
        Bucket newBucket =
            bucketMap.containsKey(count + 1)
            ? bucketMap.get(count + 1)
            : createBucketAfter(bucket);
        
        newBucket.insertFirst(node);
        
        if (bucket.empty()) removeBucket(bucket);
        
        return node;
    }
    
    public Bucket createBucketAfter(Bucket bucket) {
                
        int newCount = (bucket == head) ? 1 : bucket.count + 1;
        Bucket newBucket = new Bucket(newCount);
        
        Bucket next = bucket.next;
        
        bucket.next = newBucket;
        newBucket.next = next;
        
        next.prev = newBucket;
        newBucket.prev = bucket;
        
        bucketMap.put(newBucket.count, newBucket);
                        
        return newBucket;  
        
    }
    
    public void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        
        bucketMap.remove(bucket.count);
    }
    
    public void print() {
        Bucket curr = head.next;
        
        if (curr == tail) System.out.println("NO BUCKETS!");
        else {
            while (curr != tail) {
                System.out.println(curr.toString());
                curr = curr.next;
            }
        }
        
        System.out.println();
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

