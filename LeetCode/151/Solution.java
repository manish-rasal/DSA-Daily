/**
 * Problem: Reverse Words in a String
 * Description: Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
class Solution {
    private void reverse(char[] str, int i, int j) {
        while(i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        reverse(str, 0, n - 1);

        int start = 0;
        for(int end = 1; end < n; end++) {
            if(str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        reverse(str, start, n - 1);

        StringBuilder sb = new StringBuilder();
        boolean space = false;

        for (int i = 0; i < n; i++) {
            if (str[i] != ' ') {
                if (space && sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(str[i]);
                space = false;
            } else {
                space = true;
            }
        }

        return sb.toString().trim();
    }
}