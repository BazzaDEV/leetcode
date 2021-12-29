/*
 * @lc app=leetcode id=432 lang=java
 *
 * [432] All O`one Data Structure
 */

// @lc code=start
class AllOne {
    
    class Bucket {
        
        int count;
        HashSet<String> keys;
        
        Bucket prev;
        Bucket next;
        
        Bucket(int count) {
            this.count = count;
            keys = new HashSet<>();
            
            prev = null;
            next = null;
        }
        
        public void insert(String key) {
            keys.add(key);
        }
        
        public void remove(String key) {
            keys.remove(key);
        }
        
        public boolean empty() {
            return keys.isEmpty();
        }
    }
    
    
    
    
    Bucket head, tail;
    HashMap<Integer, Bucket> bucketMap;
    HashMap<String, Integer> keyCountMap;

    public AllOne() {
        
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        
        bucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        
        // If key is already in map, relocate it to the
        // new bucket with offset +1
        if ( keyCountMap.containsKey(key) ) {
            relocateKey(key, 1);
            
        } 
        
        // Otherwise, key is not in map.
        // Add it to the map in bucket with count 1.
        else {
            // Add key to map
            keyCountMap.put(key, 1);
        
            // Get the bucket with count 1, or create it.
            Bucket bucket = bucketMap.containsKey(1)
                ? bucketMap.get(1)
                : createBucketAfter(head, 1);
        
            // Insert key in bucket
            bucket.insert(key);
            
        }
        
        // System.out.println("Incrementing key \'" + key + "\'...");
        // print();
        
        
    }
    
    public void dec(String key) {
        int count = keyCountMap.get(key);
        // System.out.println("Key \'" + key + "\' has count " + count + " before decrement.");
        
        // If count is greater than 1, relocate the
        // key to the new bucket with offset -1.
        if (count > 1) {
            relocateKey(key, -1);
        } 
        
        // Otherwise, the new count will be 0.
        // The key should be REMOVED from the structure.
        else {
            // Remove key from map
            keyCountMap.remove(key);
            
            // Remove key from bucket
            Bucket bucket = bucketMap.get(count);
            bucket.remove(key);
            
            // If bucket is now empty, remove it from the structure
            if (bucket.empty()) removeBucket(bucket);
        }
        
        // System.out.println("Decrementing key \'" + key + "\'...");
        // print();
        
    }
    
    public String getMaxKey() {
        return tail.prev == head
            ? ""
            : tail.prev.keys.iterator().next();
        
    }
    
    public String getMinKey() {
        return head.next == tail
            ? ""
            : head.next.keys.iterator().next();
    }
    
    // Helper Methods
    
    public Bucket createBucketAfter(Bucket bucket, int count) {
        
        // Return the bucket from the map if it already exists
        if ( bucketMap.containsKey(count) ) return bucketMap.get(count);
        
        // Create bucket
        Bucket newBucket = new Bucket(count);
        
        // Insert in bucketMap
        bucketMap.put(count, newBucket);
        
        // Insert in linked list
        Bucket next = bucket.next;
        
        bucket.next = newBucket;
        newBucket.next = next;
        
        next.prev = newBucket;
        newBucket.prev = bucket;
        
        // System.out.println(bucket.count + " " + bucket.next.count + " " + bucket.next.next.count);
        
        return newBucket;
    }
    
    public void removeBucket(Bucket bucket) {
        // Remove bucket from map
        bucketMap.remove(bucket.count);
        
        // Remove it from linked list
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
    
    public void relocateKey(String key, int offset) {
        // Get the current count & bucket for the key
        int count = keyCountMap.get(key);
        Bucket bucket = bucketMap.get(count);
                
        // Remove key from map and bucket
        keyCountMap.remove(key);
        bucket.remove(key);
        
        // Get new bucket, or create it
        int newCount = count + offset;
        Bucket newBucket;
        
        if ( bucketMap.containsKey(newCount) ) {
             newBucket = bucketMap.get(newCount);
            
        } else if (offset > 0) {
            newBucket = createBucketAfter(bucket, newCount);
            
        } else {
            newBucket = createBucketAfter(bucket.prev, newCount);
            
        }
        
        // Add key to map & bucket with count + offset
        keyCountMap.put(key, newCount);
        newBucket.insert(key);
        
        // If prev bucket is now empty, remove it too
        if (bucket.empty()) removeBucket(bucket);
        
    }
    
    public void print() {
        Bucket curr = head.next;
        
        if (curr == tail) {
            System.out.println("[ *EMPTY* ]");
        } else {
            while (curr != tail) {
                System.out.println(curr.count + ": " + curr.keys.toString());
                curr = curr.next;
            }
        }
        
        System.out.println();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

