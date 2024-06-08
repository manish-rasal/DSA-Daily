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