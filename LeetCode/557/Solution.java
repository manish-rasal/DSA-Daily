/**
 * Problem: Reverse Words in a String III
 * Description: Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
class Solution {
    private void reverseString(StringBuilder str, int i, int j) {
        while(i < j) {
            char c = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, c);
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder(s);
        int i = 0, j = 0;
        while(j < n) {
            if(result.charAt(j) == ' ') {
                reverseString(result, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverseString(result, i, n - 1);
        return result.toString();
    }
}