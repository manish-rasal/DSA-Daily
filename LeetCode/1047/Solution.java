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
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if (st.empty()) {
                st.push(s.charAt(i));
            } else {
                if(st.peek() == s.charAt(i)) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
            i++;

        }
        StringBuilder result = new StringBuilder();
        while(!st.empty()) result.append(st.pop());
        return result.reverse().toString();
    }
}