/**
 * Problem: Detect Capital
 * Description: We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitalCount++;
            }
        }

        if (capitalCount == n || capitalCount == 0) {
            return true;
        }

        return capitalCount == 1 && Character.isUpperCase(word.charAt(0));
    }
}
