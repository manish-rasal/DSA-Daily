/**
 * Problem: Optimal Partition of String
 * Description: Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
 *
 * Return the minimum number of substrings in such a partition.
 *
 * Note that each character should belong to exactly one substring in a partition.
 */
class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int[] charFreq = new int[26];
        int result = 1;
        int i = 0;
        while(i < n) {
            char c = s.charAt(i);
            if(charFreq[c - 'a'] == 0) {
                charFreq[c - 'a']++;
            } else {
                result++;
                Arrays.fill(charFreq, 0);
                charFreq[c - 'a']++;
            }
            i++;
        }
        return result;
    }
}