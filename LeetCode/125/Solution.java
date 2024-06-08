/**
 * Problem: Valid Palindrome
 * Description: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }
        String s1 = str.toString();
        String s2 = str.reverse().toString();
        return s1.equals(s2);
    }
}