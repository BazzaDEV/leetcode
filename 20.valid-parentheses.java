import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {

        // LIFO - Last In First Out
        Stack<Character> stack = new Stack<>();
        
        //    METHOD        TIME COMPLEXITY
        // ------------------------------------
        // void push(E e)        O(1)
        // E pop()               O(1)
        // E peek()              O(1)T
        // boolean empty()       O(1)
        
        for (char c : s.toCharArray()) {
            
            if ( c == '(' || c == '{' || c == '[' ) {
                // Opening parentheses - push it to the stack
                stack.push(c);
                
            } else {
                // Closing parentheses
                
                // If the stack is empty, what parentheses are we closing?
                if (stack.empty()) return false;
                
                // Check if it does not match the last opened parentheses
                char lastOpened = stack.peek();
                if ( (lastOpened == '(' && c != ')') || (lastOpened == '{' && c != '}') || (lastOpened == '[' && c != ']') )
                    return false;
                
                // By elimination, only possibility is that the closing parentheses is correctly closing the last opened parentheses.
                // Thus, we have closed this pair of parentheses - the open one can be removed from the stack
                stack.pop();
                
            }
            
        }
        
        // Check if every parentheses has been closed
        return stack.empty();
        
    }
}
// @lc code=end

