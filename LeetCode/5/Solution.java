/**
 * Problem: Longest Palindromic Subsequence
 * Description: Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 */
class Solution {
    private Integer[][] memo = new Integer[1001][1001];
    private int solve(String s1, String s2, int i, int j) {
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(memo[i][j] != null) return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + solve(s1, s2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(solve(s1, s2, i + 1, j), solve(s1, s2, i, j + 1));
        }
        return memo[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        StringBuilder str = new StringBuilder(s);
        String s2 = str.reverse().toString();
        return solve(s1, s2, 0, 0);
    }
}