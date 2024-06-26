/**
 * Problem: Determine if Two Strings Are Close
 * Description: Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(m != n) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i < m; i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if((freq1[i] != 0 && freq2[i] == 0) || (freq1[i] == 0 && freq2[i] != 0)) return false;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 0; i < 26; i++) {
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}