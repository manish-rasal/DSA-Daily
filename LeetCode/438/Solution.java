/**
 * Problem: Find All Anagrams in a String
 * Description: Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
class Solution {
    private boolean areAllZero(int[] counter) {
        for(int i: counter) {
            if(i != 0) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        int[] counter = new int[26];
        for(char c: p.toCharArray()) {
            counter[c - 'a']++;
        }
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while(j < n) {
            counter[s.charAt(j) - 'a']--;
            if(j - i + 1 == k) {
                if(areAllZero(counter)) {
                    result.add(i);
                }
                counter[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return result;
    }
}