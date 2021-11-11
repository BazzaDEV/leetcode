/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        /* 

        First, let's figure out what the maximum length of
        the longest common prefix (LCP) could be.

        This will always be the length of the smallest
        string in the array of strings, 'strs'.

        For example:

        strs1 = { "Higher", "Highest" }
        
        Here, we can see that the LCP between the two
        strings in 'strs1', "Higher" and "Highest", is 
        "Highe".
        
        Now let's make a new array with the same strings
        as in 'strs1', but with one addition:

        strs2 = { "Higher", "Highest", "Hi" }

        The first two words have a LCP, "Highe", 
        just as before, but "Hi" does not share this
        prefix with them because of its shorter length.

        The LCP in 'strs2' is "Hi". Okay, one more:

        strs3 = { "Higher", "Highest", "Hi", "H" }

        Yet again, we can see that while some words share
        prefixes, the longest common prefix among all the
        strings is effectively bottlenecked by the shortest
        string, that being "H".
        
        */

        int minLen = Integer.MAX_VALUE;
        
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
        }

        /*
        
        Each iteration of the outer (while) loop will allow us
        to make the following decision:

        "Is the ith character in the longest common prefix?"

        We will check all characters up to, but not including,
        the 'minLen'th character, where 'minLen' is the length of the
        shortest string in 'strs', and thus the maximum length
        of the LCP in 'strs'.

        The inner (for) loop checks if the ith character is the
        same for all strings in 'strs'. Two things can happen:

        (1)  If it is, then we can add the ith character to
             our longest common prefix and consider the next
             character for the LCP.

        (2)  If there are any two strings in 'strs' which do 
             not have the same ith characters, then we cannot
             add this character to the LCP ...
        
             ... and since we can no longer consider adding the
             ith character to the LCP, we cannot consider adding
             any more characters to the LCP. We can break out of
             the inner & outer loops to end our search.
        
        At this point, we have finished iterating through both
        loops. Either because all characters up to 'minLen' were
        successfully considered for the LCP, or we broke early.

        Nonetheless, we have found the LCP - problem solved!

        */
        
        for (int i = 0; i < minLen; i++) {

            char c = strs[0].charAt(i);
            
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
            
        }
        
        return strs[0].substring(0, minLen);

    }
}
// @lc code=end

