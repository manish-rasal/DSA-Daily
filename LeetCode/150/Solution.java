/**
 * Problem: Evaluate Reverse Polish Notation
 * Description: You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
class Solution {
    public int evalRPN(String[] strs) {
        Stack<Integer> st = new Stack<>();
        HashMap<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a, b) -> (a + b));
        map.put("-", (a, b) -> (a - b));
        map.put("*", (a, b) -> (a * b));
        map.put("/", (a, b) -> (a / b));

        for(String str: strs) {
            if(map.containsKey(str)) {
                int b = st.pop();
                int a = st.pop();
                st.add(map.get(str).apply(a, b));
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }
}