/**
 * Problem: Count Beautiful Substrings I
 * Description: You are given a string s and a positive integer k.
 *
 * Let vowels and consonants be the number of vowels and consonants in a string.
 *
 * A string is beautiful if:
 *
 * vowels == consonants.
 * (vowels * consonants) % k == 0, in other terms the multiplication of vowels and consonants is divisible by k.
 * Return the number of non-empty beautiful substrings in the given string s.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Consonant letters in English are every letter except vowels.
 */
class Solution {
    public int beautifulSubstrings(String s, int k) {
        List<Character> vow = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int n = s.length();
        int[] vowels = new int[n + 1];
        int[] consonants = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(vow.contains(s.charAt(i))) {
                vowels[i + 1] = vowels[i] + 1;
                consonants[i + 1] = consonants[i];
            } else {
                consonants[i + 1] = consonants[i] + 1;
                vowels[i + 1] = vowels[i];
            }
        }
        int result = 0;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= i - 2; j++) {
                int v = vowels[i] - vowels[j];
                int c = consonants[i] - consonants[j];
                if (v == c && v * c % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}