/**
 * Problem: Minimum Number of Steps to Make Two Strings Anagram
 * Description: You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 */
class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] freqDiff = new int[26];
        for(int i = 0; i < n; i++) {
            freqDiff[s.charAt(i) - 'a']++;
            freqDiff[t.charAt(i) - 'a']--;
        }
        int result = 0;
        for(int i: freqDiff) {
            if(i > 0)
                result += i;
        }
        return result;
    }
}