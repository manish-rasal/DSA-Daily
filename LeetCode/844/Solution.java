/**
 * Problem: Backspace String Compare
 * Description: Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 */
class Solution {
    private String processString(String str) {
        StringBuilder result = new StringBuilder();
        int backspaceCount = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if(c == '#') backspaceCount++;
            else if(backspaceCount > 0) backspaceCount--;
            else result.append(c);
        }
        return result.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }
}