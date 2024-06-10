/**
 * Problem: Maximum Number of Vowels in a Substring of Given Length
 * Description: Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */
class Solution {
    public int maxVowels(String s, int k) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int result = 0, vowelCount = 0;
        int i = 0, j = 0;
        while(j < s.length()) {
            if(vowels.contains(s.charAt(j))) vowelCount++;
            if(j - i + 1 == k) {
                result = Math.max(result, vowelCount);
                if(vowels.contains(s.charAt(i))) vowelCount--;
                i++;
            }
            j++;
        }
        return result;
    }
}