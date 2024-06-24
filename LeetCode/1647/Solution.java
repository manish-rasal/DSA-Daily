/**
 * Problem: Minimum Deletions to Make Character Frequencies Unique
 * Description: A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 */
class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Integer> valuesList = new ArrayList<>(freq.values());

        Collections.sort(valuesList, Collections.reverseOrder());
        int prev = valuesList.get(0), result = 0;
        for(int i = 1; i < valuesList.size(); i++) {
            if(valuesList.get(i) >= prev) {
                if(prev > 0) prev--;
                result += valuesList.get(i) - prev;
            } else {
                prev = valuesList.get(i);
            }
        }
        return result;
    }
}