/**
 * Problem: Count Subarrays Where Max Element Appears at Least K Times
 * Description: You are given an integer array nums and a positive integer k.
 *
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 *
 * A subarray is a contiguous sequence of elements within an array.
 */
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxE = 0;
        for(int i: nums) {
            maxE = Math.max(maxE, i);
        }

        int n = nums.length;
        int i = 0, j = 0;
        int maxECount = 0;
        long result = 0;
        while(j < n) {
            if(nums[j] == maxE) maxECount++;

            while(maxECount >= k) {
                result += n - j;
                if(nums[i] == maxE) maxECount--;
                i++;
            }
            j++;
        }
        return result;
    }
}