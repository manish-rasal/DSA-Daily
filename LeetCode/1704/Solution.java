/**
 * Problem: Determine if String Halves Are Alike
 * Description: You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 */
class Solution {
    public boolean halvesAreAlike(String s) {
        int vowelCount = 0;
        int n = s.length();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(int i = 0; i < n / 2; i++) {
            if(vowels.contains(s.charAt(i))) {
                vowelCount++;
            }
            if(vowels.contains(s.charAt(n - i - 1))) {
                vowelCount--;
            }
        }
        return vowelCount == 0;
    }
}