/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start
class MyHashSet {
    
    class Bucket {
        LinkedList<Integer> keys;
        
        public Bucket() {
            this.keys = new LinkedList<>();
        }
        
        public void add(int key) {
            if ( contains(key) ) return;
            
            keys.addFirst(key);
        }
        
        public void remove(int key) {
            keys.removeFirstOccurrence(key);
        }
        
        public boolean contains(int key) {
            return keys.indexOf(key) != -1;
        }
    }
    
    

    
    int maxBuckets;
    Bucket[] buckets;

    public MyHashSet() {
        maxBuckets = 811;
        buckets = new Bucket[maxBuckets];
        
        for (int i = 0; i < maxBuckets; i++) {
            buckets[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        int hashIndex = hash(key);
        Bucket bucket = buckets[hashIndex];
        
        bucket.add(key);
    }
    
    public void remove(int key) {
        int hashIndex = hash(key);
        Bucket bucket = buckets[hashIndex];
        
        bucket.remove(key);
    }
    
    public boolean contains(int key) {
        int hashIndex = hash(key);
        Bucket bucket = buckets[hashIndex];
        
        return bucket.contains(key);
    }
    
    private int hash(int key) {
        return key % maxBuckets;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

