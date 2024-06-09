/**
 * Problem: The Celebrity Problem
 * Description: A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
 * A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
 * Return the index of the celebrity, if there is no celebrity return -1.
 * Note: Follow 0 based indexing.
 * Follow Up: Can you optimize it to O(N)
 */
class Solution
{
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        if(n == 1) return 0;
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            st.push(i);
        }

        while(st.size() >= 2) {
            int a = st.pop();
            int b = st.pop();

            if(M[a][b] == 1) st.push(b);
            else if(M[b][a] == 1) st.push(a);
        }

        if(st.size() == 0) return -1;
        int c = st.pop();
        for(int i = 0; i < n; i++) {
            if(i != c && (M[i][c] != 1 || M[c][i] != 0)) return -1;
        }
        return c;
    }
}