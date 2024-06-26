/**
 * Problem: Maximum Bags With Full Capacity of Rocks
 * Description: You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks. The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.
 *
 * Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.
 */
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int result = 0;
        for(int i = 0; i < n; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        for(int i = 0; i < n; i++) {
            if(additionalRocks < capacity[i]) return result;
            else {
                additionalRocks -= capacity[i];
            }
            result++;
        }
        return result;
    }
}