/**
 * Problem: Count Number of Homogenous Substrings
 * Description: Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
 *
 * A string is homogenous if all the characters of the string are the same.
 *
 * A substring is a contiguous sequence of characters within a string.
 */
class Solution {
    final int MOD = 1000000007;
    public int countHomogenous(String s) {
        int n = s.length();
        int i = 0;
        long result = 0;  // Use long to avoid overflow before the modulo operation
        while (i < n) {
            int count = 0;
            char c = s.charAt(i);
            while (i < n && s.charAt(i) == c) {
                count++;
                i++;
            }
            result = (result + (long)count * (count + 1) / 2) % MOD;
        }
        return (int) result;
    }
}
