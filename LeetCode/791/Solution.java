/**
 * Problem: Custom Sort String
 * Description: You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
 *
 * Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
 *
 * Return any permutation of s that satisfies this property.
 */
class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder str = new StringBuilder();

        for(char c: order.toCharArray()) {
            while(freq[c - 'a'] > 0) {
                str.append(c);
                freq[c - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++) {
            while(freq[i] > 0) {
                str.append((char)(i + 'a'));
                freq[i]--;
            }
        }
        return str.toString();
    }
}