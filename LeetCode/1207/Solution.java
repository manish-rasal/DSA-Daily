/**
 * Problem: Unique Number of Occurrences
 * Description: Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i: arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i: freq.values()) {
            if(!set.add(i)) return false;
        }
        return true;
    }
}