/**
 * Problem: Number of Good Pairs
 * Description: Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i: nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int result = 0;
        for(int value: freq.values()) {
            if(value > 1) {
                result += value * (value - 1) / 2;
            }
        }
        return result;
    }
}