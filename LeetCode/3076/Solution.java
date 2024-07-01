/**
 * Problem: Shortest Uncommon Substring in an Array
 * Description: You are given an array arr of size n consisting of non-empty strings.
 *
 * Find a string array answer of size n such that:
 *
 * answer[i] is the shortest
 * substring
 *  of arr[i] that does not occur as a substring in any other string in arr. If multiple such substrings exist, answer[i] should be the
 * lexicographically smallest
 * . And if no such substring exists, answer[i] should be an empty string.
 * Return the array answer.
 */
class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] result = new String[n];
        HashMap<String, Integer> uniqueSubstring = new HashMap<>();
        for(String str: arr) {
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < str.length(); i++) {
                for(int j = i + 1; j <= str.length(); j++) {
                    String substr = str.substring(i, j);
                    if(!set.contains(substr)) {
                        uniqueSubstring.put(substr, uniqueSubstring.getOrDefault(substr, 0) + 1);
                        set.add(substr);
                    }
                }
            }
        }

        int r = 0;
        for (String str : arr) {
            String shortest = null;
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j <= str.length(); j++) {
                    String substr = str.substring(i, j);
                    if (uniqueSubstring.get(substr) == 1 && (shortest == null || substr.length() < shortest.length() || (substr.length() == shortest.length() && substr.compareTo(shortest) < 0))) {
                        shortest = substr;
                    }
                }
            }
            result[r] = (shortest != null) ? shortest : "";  // Ensure we handle the case where no unique substring is found
            r++;
        }
        return result;
    }
}