/**
 * Problem: Check if the Sentence Is Pangram
 * Description: A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 */
class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        int[] freq = new int[26];
        for(char c: sentence.toCharArray()) {
            freq[c - 'a']++;
        }
        for(int i: freq) {
            if(i == 0) return false;
        }
        return true;
    }
}