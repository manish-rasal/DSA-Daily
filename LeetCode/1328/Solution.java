/**
 * Problem: Break a Palindrome
 * Description: Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
 *
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 *
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
 */
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) return "";
        int i = 0;
        StringBuilder str = new StringBuilder(palindrome);
        while(i < n / 2) {
            if(palindrome.charAt(i) != 'a') {
                str.setCharAt(i, 'a');
                return str.toString();
            }
            i++;
        }
        str.setCharAt(n - 1, 'b');
        return str.toString();
    }
}