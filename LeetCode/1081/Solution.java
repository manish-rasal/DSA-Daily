/**
 * Problem: Smallest Subsequence of Distinct Characters
 * Description: Given a string s, return the
 * lexicographically smallest
 *
 * subsequence
 *  of s that contains all the distinct characters of s exactly once.
 */
class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        int n = s.length();

        for(int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] isTaken = new boolean[26];

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!isTaken[c - 'a']) {
                while(str.length() > 0 && str.charAt(str.length() - 1) > c && lastIndex[str.charAt(str.length() - 1) - 'a'] > i) {
                    isTaken[str.charAt(str.length() - 1) - 'a'] = false;
                    str.deleteCharAt(str.length() - 1);
                }
                str.append(c);
                isTaken[c - 'a'] = true;
            }
        }
        return str.toString();
    }
}