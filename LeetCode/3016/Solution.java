/**
 * Problem: Minimum Number of Pushes to Type Word II
 * Description: You are given a string word containing lowercase English letters.
 *
 * Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
 *
 * It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.
 *
 * Return the minimum number of pushes needed to type word after remapping the keys.
 *
 * An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.
 */
class Solution {
    public int minimumPushes(String word) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int assignKey = 2;
        int result = 0;
        List<Integer> vals = new ArrayList<>(freq.values());
        Collections.sort(vals, Collections.reverseOrder());
        for(int v: vals) {
            if(assignKey > 9) assignKey = 2;
            map.put(assignKey, map.getOrDefault(assignKey, 0) + 1);
            result += map.get(assignKey) * v;
            assignKey++;
        }
        return result;
    }
}