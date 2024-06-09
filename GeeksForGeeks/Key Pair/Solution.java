/**
 * Problem: Key Pair
 * Description: Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.
 */
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        HashSet<Integer> set = new HashSet<>();

        for(int i: arr) {
            if(set.contains(x - i)) return true;
            else set.add(i);
        }
        return false;
    }
}