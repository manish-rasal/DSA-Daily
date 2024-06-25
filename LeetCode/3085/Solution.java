/**
 * Problem: Minimum Deletions to Make String K-Special
 * Description: You are given a string word and an integer k.
 *
 * We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.
 *
 * Here, freq(x) denotes the
 * frequency
 *  of the character x in word, and |y| denotes the absolute value of y.
 *
 * Return the minimum number of characters you need to delete to make word k-special.
 */
class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char c: word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int result = word.length();
        int deletions = 0;
        for(int i = 0; i < 26; i++) {
            int del = deletions;
            for(int j = 25; j >= 0; j--) {
                if(freq[j] - freq[i] <= k) {
                    break;
                }
                del += freq[j] - freq[i] - k;
            }
            result = Math.min(result, del);
            deletions += freq[i];

        }
        return result;
    }
}