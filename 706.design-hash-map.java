/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class MyHashMap {

    class Bucket {

        int value;
        LinkedList< Pair<Integer, Integer> > container;

        public Bucket(int value) {
            this.value = value;
            container = new LinkedList<>();
        }

        public void insert(Integer key, Integer value) {
            int index = indexOf(key);

            if (index != -1) {
                container.remove(index);
            }

            container.addFirst(new Pair<Integer, Integer>(key, value));

            return;
        }

        public boolean delete(Integer key) {
            int index = indexOf(key);

            if (index == -1) {
                return false;
            } else {
                container.remove(index);
                return true;
            }
        }

        public int get(Integer key) {
            int index = indexOf(key);

            if (index == -1) return -1;
            else return container.get(index).getValue();
        }

        public boolean contains(Integer key) {
            return indexOf(key) != -1;
        }

        public int indexOf(Integer key) {
            ListIterator< Pair<Integer, Integer> > itr = container.listIterator();

            while (itr.hasNext()) {
                int i = itr.nextIndex();
                Pair<Integer, Integer> p = itr.next();

                if ( p.getKey().equals(key) ) return i; 
            }
            
            return -1;
        }
        
        @Override
        public String toString() {
            StringBuilder strB = new StringBuilder();
            if (container.size() < 1) {
                strB.append("[ *EMPTY* ]");
                
            } else {
                ListIterator< Pair<Integer, Integer> > itr = container.listIterator();

                strB.append("[");
                while (itr.hasNext()) {
                    int i = itr.nextIndex();
                    Pair<Integer, Integer> p = itr.next();

                    strB.append("(").append(p.getKey()).append(",").append(p.getValue()).append(")");
                    if (itr.hasNext()) strB.append(", ");
                }
                
                strB.append("]");
                
            }
            
            return strB.toString().trim();
            
        }

    }




    Bucket[] buckets;
    int capacity;

    public MyHashMap() {
        capacity = 797;
        buckets = new Bucket[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new Bucket(i);
        }
    }
    
    public void put(int key, int value) {
        Bucket bucket = getBucketFromHash(key);
        bucket.insert(key, value);
    }
    
    public int get(int key) {
        Bucket bucket = getBucketFromHash(key);
        return bucket.get(key);
    }
    
    public void remove(int key) {
        Bucket bucket = getBucketFromHash(key);
        bucket.delete(key);
    }

    private Bucket getBucketFromHash(int key) {
        return buckets[hash(key)];
    }
    
    private int hash(int key) {
        return key % capacity;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

