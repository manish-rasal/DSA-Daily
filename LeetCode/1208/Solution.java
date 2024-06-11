/**
 * Problem: Get Equal Substrings Within Budget
 * Description: You are given two strings s and t of the same length and an integer maxCost.
 *
 * You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).
 *
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 */
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int currCost = 0;
        int i = 0, j = 0, n = t.length();
        int maxLen = 0;
        while(j < n) {
            currCost += Math.abs(s.charAt(j) - t.charAt(j));
            while(currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}