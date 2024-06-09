/**
 * Problem: Maximum Subarray
 * Description: Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i: nums) {
            sum += i;
            maxSum = Math.max(sum, maxSum);
            sum = (sum  < 0)? 0: sum;
        }
        return maxSum;
    }
}