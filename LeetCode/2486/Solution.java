/**
 * Problem: Append Characters to String to Make Subsequence
 * Description: You are given two strings s and t consisting of only lowercase English letters.
 *
 * Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
 *
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 */
class Solution {
    public int appendCharacters(String s, String t) {
        int i, j = 0;
        for(i = 0; i < s.length() && j < t.length(); i++) {
            if(s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return t.length() - j;
    }
}