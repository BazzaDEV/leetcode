/*
 * @lc app=leetcode id=379 lang=java
 *
 * [379] Design Phone Directory
 */

// @lc code=start
class PhoneDirectory {

    boolean[] slots;
    int nextFree;

    public PhoneDirectory(int maxNumbers) {
        slots = new boolean[maxNumbers];
        nextFree = 0;
        
    }
    
    public int get() {
        
        if (nextFree == -1) return nextFree;
        
        slots[nextFree] = true;
        int oldFree = nextFree, i = nextFree;
        while (i < slots.length) {
            if (!slots[i]) {
                nextFree = i;
                break;
            }
            
            i++;
        }
        
        if (i == slots.length) nextFree = -1;
        
        return oldFree;
        
    }
    
    public boolean check(int number) {
        
        return !slots[number];
        
    }
    
    public void release(int number) {
        
        slots[number] = false;
        
        if (nextFree == -1 || number < nextFree) nextFree = number;
        
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
// @lc code=end

