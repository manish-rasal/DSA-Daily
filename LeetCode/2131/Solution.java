/**
 * Problem: Longest Palindrome by Concatenating Two Letter Words
 * Description: You are given an array of strings words. Each element of words consists of two lowercase English letters.
 *
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
 *
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 *
 * A palindrome is a string that reads the same forward and backward.
 */
class Solution {
    public int longestPalindrome(String[] words) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        boolean centreUsed = false;
        for(String word: words) {
            StringBuilder str = new StringBuilder(word);
            String rev = str.reverse().toString();
            if(!rev.equals(word)) {
                if(map.get(word) > 0 && map.getOrDefault(rev, 0) > 0) {
                    map.put(word, map.get(word) - 1);
                    map.put(rev, map.getOrDefault(rev, 0) - 1);
                    result += 4;
                }
            } else {
                if(map.get(word) >= 2) {
                    map.put(word, map.get(word) - 2);
                    result += 4;
                } else if(map.get(word) == 1 && centreUsed == false) {
                    result += 2;
                    centreUsed = true;
                    map.put(word, map.get(word) - 1);
                }
            }
        }
        return result;
    }
}