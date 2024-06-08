/**
 * Problem: Length of Last Word
 * Description: Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal ubstring consisting of non-space characters only.
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int right = n;
        int i = n - 1;
        while(i > 0) {
            if(s.charAt(i) != ' ' && right == n) {
                right = i;
            } else if(s.charAt(i) == ' ' && right != n) {
                return right - i;
            }
            i--;
        }
        return right;
    }
}
