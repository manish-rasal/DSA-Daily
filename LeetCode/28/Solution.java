/**
 * Problem: Find the Index of the First Occurrence in a String
 * Description: Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m > n) return -1;

        for(int i = 0; i <= n - m; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while(j < m) {
                    if(haystack.charAt(i + j) == needle.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                if(j == m) return i;
            }
        }
        return -1;
    }
}