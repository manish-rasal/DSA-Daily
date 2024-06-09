/**
 * Problem: Valid Anagram
 * Description: An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) <= 0) return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}