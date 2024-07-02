/**
 * Problem: Word Pattern
 * Description: Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 */
class Solution {
    private List<String> process(String s) {
        int n = s.length(), i = 0;
        List<String> ans = new ArrayList<>();
        while(i < n) {
            if(s.charAt(i) == ' ') {
                i++;
                continue;
            }
            StringBuilder str = new StringBuilder();
            while(i < n && s.charAt(i) != ' ') {
                str.append(s.charAt(i));
                i++;
            }
            ans.add(str.toString());
        }
        return ans;
    }
    public boolean wordPattern(String pattern, String s) {
        List<String> words = process(s);
        if(words.size() != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 0; i < words.size(); i++) {
            char c = pattern.charAt(i);
            String word = words.get(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word)) return false;
            } else {
                if(map.containsValue(word)) return false;
                map.put(c, word);
            }
        }
        return true;
    }
}