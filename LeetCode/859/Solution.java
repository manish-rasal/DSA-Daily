/**
 * Problem: Buddy Strings
 * Description: Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 *
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (!set.add(c)) return true;
            }
            return false;
        }

        int swap = 0;
        char s1='A' ,g1='A';
        for (int i = 0; i< s.length(); i++) {
            if ( s.charAt(i) != goal.charAt(i)) {
                swap++;
                switch (swap) {
                    case 1:
                        s1 = s.charAt(i);
                        g1 = goal.charAt(i);
                        break;
                    case 2:
                        if (s1 != goal.charAt(i) || g1 != s.charAt(i)) return false;
                        break;
                    case 3:
                        return false;
                }
            }
        }
        if (swap == 1) return false;
        return true;

    }
}