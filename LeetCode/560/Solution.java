/**
 * Problem: Subarray Sum Equals K
 * Description: Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int result = 0;
        map.put(0, 1);
        for(int i: nums) {
            prefixSum += i;
            if(map.containsKey(prefixSum - k)) {
                result += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}