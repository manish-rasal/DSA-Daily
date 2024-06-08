/**
 * Problem: Remove All Adjacent Duplicates In String
 * Description: You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 */
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder(s);
        int stackPtr = -1;
        for(char c: s.toCharArray()) {
            if(stackPtr == -1 || c != s.charAt(stackPtr)) {
                stackPtr++;
                str.setCharAt(stackPtr, c);
            } else if(c == s.charAt(stackPtr)){
                stackPtr--;
            }
        }
        if(stackPtr == -1) return "";
        return str.substring(0, stackPtr + 1).toString();
    }
}