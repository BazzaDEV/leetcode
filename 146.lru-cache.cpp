/*
 * @lc app=leetcode id=146 lang=cpp
 *
 * [146] LRU Cache
 */

// @lc code=start
class Node {
public:
    int key;
    int value;
    Node *prev;
    Node *next;

    Node(int key, int value) {
        this->key = key;
        this->value = value;
        this->prev = nullptr;
        this->next = nullptr;
    }

};
class LRUCache {
private:
    unordered_map<int, Node*> mp;
    int capacity;
    Node *head;
    Node *tail;
    
public:
    LRUCache(int capacity) {
        this->capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        Node *node = mapGet(key);
        if (node) {
            remove(node);
            addFirst(node);

            return node->value;
        }

        return -1;
    }
    
    void put(int key, int value) {

        Node *node = mapGet(key);

        if (node) {
            node->value = value;
            remove(node);
        } else {
            node = new Node(key, value);
            pair<int, Node*> pNode(key, node);
            mp.insert(pNode);
        }
        
        addFirst(node);

        if (mp.size() > capacity) {
            mapRemove(tail->prev->key);
            remove(tail->prev);
        }
    }

    void remove(Node *node) {
        Node *prev = node->prev;
        Node *next = node->next;

        prev->next = next;
        next->prev = prev;
 
    }

    void addFirst(Node *node) {
        Node *next = head->next;
        head->next = node;
        node->next = next;

        next->prev = node;
        node->prev = head;
    }

    Node *mapGet(int key) {
        unordered_map<int, Node*>::iterator itr = mp.find(key);
        if ( itr == mp.end() ) return nullptr;
        return itr->second;
    }

    void mapRemove(int key) {
        unordered_map<int, Node*>::iterator itr = mp.find(key);
        mp.erase(itr);
    }

};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
// @lc code=end

