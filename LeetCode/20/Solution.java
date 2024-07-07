/**
 * Problem: Valid Parentheses
 * Description: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> st = new Stack<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                if(st.isEmpty() || st.pop() != map.get(c)) {
                    return false;
                }
            } else {
                st.push(c);
            }
        }
        return st.size() == 0;
    }
}