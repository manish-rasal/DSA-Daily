/**
 * Problem: Count Substrings Starting and Ending with Given Character
 * Description: You are given a string s and a character c. Return the total number of
 * substrings
 *  of s that start and end with c.
 */
class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                count++;
            }
        }
        return count * (count + 1) / 2;
    }
}