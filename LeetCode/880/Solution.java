/**
 * Problem: Decoded String at Index
 * Description: You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
 *
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
 * Given an integer k, return the kth letter (1-indexed) in the decoded string.
 */
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        // First pass to find the size of the expanded string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                size++;
            } else {
                int d = c - '0';
                size *= d;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int d = c - '0';
                size /= d;
                k %= size;
            } else {
                if (k == 0 || k == size) {
                    return String.valueOf(c);
                }
                size--;
            }
        }
        return "";
    }
}